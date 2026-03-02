package com.mathan.portfolio.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mathan.portfolio.models.Experience
import com.mathan.portfolio.store.AppState

@Composable
fun WorkTab(state: AppState) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            PortfolioCard("Experience") {
                Column {
                    state.experiences.forEachIndexed { index, exp ->
                        ExperienceItem(exp, isLast = index == state.experiences.size - 1)
                    }
                }
            }
        }
    }
}

@Composable
fun ExperienceItem(exp: Experience, isLast: Boolean) {
    Row(modifier = Modifier.height(IntrinsicSize.Min)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(AccentBlue)
            )
            if (!isLast) {
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .weight(1f)
                        .background(Color(0xFF30363D))
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.padding(bottom = 24.dp)) {
            Text(exp.period, color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(exp.title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(exp.company, color = TextPrimary, fontSize = 14.sp)
            Text(exp.location, color = TextSecondary, fontSize = 12.sp)
        }
    }
}
