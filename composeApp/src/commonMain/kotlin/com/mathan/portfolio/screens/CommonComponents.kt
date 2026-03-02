package com.mathan.portfolio.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Colors from the design
val BackgroundDark = Color(0xFF0D1117)
val CardBackground = Color(0xFF161B22)
val AccentBlue = Color(0xFF58A6FF)
val TextPrimary = Color(0xFFC9D1D9)
val TextSecondary = Color(0xFF8B949E)

private val BorderGradient = Brush.verticalGradient(
    colors = listOf(
        AccentBlue.copy(alpha = 0.4f),
        Color(0xFF6A4DFF).copy(alpha = 0.4f), // A purplish color
        CardBackground.copy(alpha = 0.1f)
    )
)
private val CardBrush = Brush.verticalGradient(
    colors = listOf(
        CardBackground.copy(alpha = 0.95f),
        CardBackground.copy(alpha = 0.9f)
    )
)

@Composable
fun PortfolioCard(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(CardBrush) // Use gradient for background
            .border(
                width = 1.dp,
                brush = BorderGradient, // Use gradient for border
                shape = RoundedCornerShape(16.dp)
            )
            .padding(20.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        content()
    }
}

@Composable
fun ContactItem(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier.padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFF1F242C))
                .border(1.dp, Color(0xFF30363D), RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, null, tint = AccentBlue, modifier = Modifier.size(16.dp))
        }
        Spacer(modifier = Modifier.width(12.dp))
        Text(text, color = TextPrimary, fontSize = 14.sp)
    }
}
