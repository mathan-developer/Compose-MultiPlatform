package com.mathan.portfolio.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mathan.portfolio.store.AppState

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectsTab(state: AppState) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            PortfolioCard("Projects") {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    state.projects.forEach { project ->
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFF1F242C))
                                .border(1.dp, Color(0xFF30363D), RoundedCornerShape(12.dp))
                                .padding(horizontal = 20.dp, vertical = 12.dp)
                        ) {
                            Text(project.title, color = TextPrimary, fontSize = 14.sp)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Read Published Blog",
                    color = AccentBlue,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.clickable { /* Handle link */ }
                )
            }
        }
    }
}
