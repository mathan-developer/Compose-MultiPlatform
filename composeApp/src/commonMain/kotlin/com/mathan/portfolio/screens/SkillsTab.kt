package com.mathan.portfolio.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mathan.portfolio.store.AppState

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillsTab(state: AppState) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            PortfolioCard("Skills") {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    state.skills.forEach { skill ->
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color(0xFF1F242C))
                                .border(1.dp, Color(0xFF30363D), RoundedCornerShape(16.dp))
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            Text(skill, color = TextPrimary, fontSize = 14.sp)
                        }
                    }
                }
            }
        }
    }
}
