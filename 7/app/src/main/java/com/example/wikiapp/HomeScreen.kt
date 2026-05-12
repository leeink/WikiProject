package com.example.wikiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wikiapp.ui.theme.Teal
import com.example.wikiapp.viewmodel.Article
import com.example.wikiapp.viewmodel.ArticleViewModel

@Composable
fun HomeScreen(
    onNavigate: (String) -> Unit = {},
    viewModel: ArticleViewModel = viewModel(),
) {
    val articles by viewModel.articles.collectAsStateWithLifecycle()

    when {
        articles.isLoading -> LoadingScreen(message = articles.message)
        articles.isError   -> ErrorScreen(
            message = articles.message,
            onRetry = { viewModel.fetchArticles() }
        )
        else -> ArticleList(articles.articles)
    }
}

@Composable
fun ArticleList(articles: List<Article>){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Teal)
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Articles",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            items(articles) { article ->
                ArticleItem(
                    article = article,
                    onClick = {  }
                )
            }
        }
    }
}

@Composable
private fun ArticleItem(
    article: Article,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Text(
            text = article.title,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )

        Spacer(Modifier.height(6.dp))

        Text(
            text = article.content,
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            lineHeight = 18.sp,
        )

        Spacer(Modifier.height(10.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(22.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF0F6E56)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = article.author.take(1).uppercase(),
                    color = Color(0xFF9FE1CB),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
            Spacer(Modifier.width(6.dp))
            Text(
                text = article.author,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
            )
        }

        Spacer(Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f))
        )
    }
}

@Composable
fun LoadingScreen(message: String){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        CircularProgressIndicator()
        Text(
            text = message
        )
    }
}

@Composable
fun ErrorScreen(message: String,
                onRetry: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Icon(
            imageVector = Icons.Filled.Clear,
            contentDescription = null,
            tint = Color.Red,
        )
        Text(
            text = message,
            fontSize = 24.sp,
        )
        TextButton(
            onClick = onRetry
        ){
            Text(
                text = "Retry Click Here",
            )
        }
    }
}