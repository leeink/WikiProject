package com.example.wikiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoxList(){
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 16.dp, horizontal = 8.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        repeat(10) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .background(Color.Cyan)
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        Column {
                            Text(
                                text = "Box Title",
                            )
                            Text(
                                text = "Writer",
                                fontSize = 14.sp
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                            .border(1.dp, MaterialTheme.colorScheme.secondary)
                    ){
                        Text(
                            text = "Text Area Lorem Ipsum has been the industry's " +
                                    "standard dummy text ever since the 1500s, " +
                                    "when an unknown printer took a galley of type "
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ){
                        Button(
                            onClick = {  },
                            shape = RoundedCornerShape(1.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("좋아요")
                        }
                        Button(
                            onClick = {  },
                            shape = RoundedCornerShape(1.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("댓글")
                        }
                        Button(
                            onClick = {  },
                            shape = RoundedCornerShape(1.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("공유")
                        }
                    }
                }
            }
        }
    }
}