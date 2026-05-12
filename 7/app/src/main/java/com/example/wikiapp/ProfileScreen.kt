package com.example.wikiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wikiapp.ui.theme.Teal
import com.example.wikiapp.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = viewModel(),
    onNavigate: (String) -> Unit = {},
) {
    val profile by viewModel.profile.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Teal)
            )
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.BottomCenter)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.background)
                    .padding(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                        .background(Color(0xFF0F6E56)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = profile.name.take(2).uppercase(),
                        color = Color(0xFF9FE1CB),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(12.dp))
            Text(profile.name, fontSize = 18.sp, fontWeight = FontWeight.Medium)
            Spacer(Modifier.height(2.dp))
            Text(
                profile.job,
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            )

            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .border(
                        0.5.dp,
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                        RoundedCornerShape(8.dp)
                    )
            ) {
                listOf("24" to "Posts", "138" to "Followers", "72" to "Following")
                    .forEachIndexed { i, (count, label) ->
                        Column(
                            modifier = Modifier.weight(1f).padding(vertical = 12.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(count, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                            Text(
                                label, fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                            )
                        }
                        if (i < 2) HorizontalDivider(
                            modifier = Modifier
                                .width(0.5.dp)
                                .height(40.dp)
                                .align(Alignment.CenterVertically),
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
                        )
                    }
            }

            Spacer(Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .border(
                        0.5.dp,
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                        RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ProfileInfoRow(icon = Icons.Default.Email, label = "Email", value = profile.email)
                ProfileInfoRow(icon = Icons.Default.LocationOn, label = "Location", value = profile.location)
            }

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = { onNavigate("edit_profile") },
                modifier = Modifier.fillMaxWidth().height(44.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Teal)
            ) {
                Text("Edit Profile", fontWeight = FontWeight.Medium)
            }

            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
private fun ProfileInfoRow(icon: ImageVector, label: String, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
        )
        Spacer(Modifier.width(10.dp))
        Text(
            label,
            modifier = Modifier.width(64.dp),
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
        )
        Text(value, fontSize = 13.sp)
    }
}