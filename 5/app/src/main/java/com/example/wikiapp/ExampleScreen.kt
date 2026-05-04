package com.example.wikiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExampleScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("BAD (Composition)", "GOOD (Layout)")

    Column(modifier = Modifier.fillMaxSize()) {

        // 탭 선택
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = {
                        Text(
                            text = title,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
            }
        }

        when (selectedTab) {
            0 -> BadExample()
            1 -> GoodExample()
        }
    }
}

// ============================================================
//  BAD — Composition 단계에서 State 읽음
//  스크롤마다 Recomposition 발생
//  Layout Inspector에서 Recomposition Count가 계속 올라감
// ============================================================
@Composable
fun BadExample() {
    val listState = rememberLazyListState()

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .offset(
                    y = with(LocalDensity.current) {
                        // Composition 단계에서 읽음
                        (listState.firstVisibleItemScrollOffset / 2).toDp()
                    }
                )
                .background(Color(0xFF1976D2)),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "BAD 배경",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Composition 단계에서 읽음",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 13.sp
                )
                Text(
                    text = "스크롤 offset: ${listState.firstVisibleItemScrollOffset}px",
                    color = Color.Yellow,
                    fontSize = 12.sp
                )
            }
        }

        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(top = 240.dp)
        ) {
            items(50) { index ->
                ListItem(index = index, color = Color(0xFFFFEBEE))
            }
        }
    }
}

// ============================================================
//  GOOD — Layout 단계에서 State 읽음
//  스크롤해도 Recomposition 없음
//  Layout Inspector에서 Recomposition Count 올라가지 않음
// ============================================================
@Composable
fun GoodExample() {
    val listState = rememberLazyListState()

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .offset {
                    // Layout 단계에서 읽음
                    IntOffset(
                        x = 0,
                        y = listState.firstVisibleItemScrollOffset / 2
                    )
                }
                .background(Color(0xFF388E3C)),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "GOOD 배경",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Layout 단계에서 읽음",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 13.sp
                )
                Text(
                    text = "Recomposition 없이 스크롤됨",
                    color = Color.Yellow,
                    fontSize = 12.sp
                )
            }
        }

        // 리스트
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(top = 240.dp)
        ) {
            items(50) { index ->
                ListItem(index = index, color = Color(0xFFF1F8E9))
            }
        }
    }
}

@Composable
fun ListItem(index: Int, color: Color) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${index + 1}",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.width(40.dp)
            )
            Text(
                text = "Item ${index + 1} — 스크롤하면서 Layout Inspector 확인",
                fontSize = 14.sp
            )
        }
    }
}
