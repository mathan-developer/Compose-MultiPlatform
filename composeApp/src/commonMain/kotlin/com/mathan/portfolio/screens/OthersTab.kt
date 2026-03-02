package com.mathan.portfolio.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mathan.portfolio.store.AppState

@Composable
fun OthersTab(state: AppState, onShowToast: (String) -> Unit) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.fillMaxSize()) {
        item {
            PortfolioCard("Certification") {
                state.certifications.forEach { cert ->
                    Text(cert, color = TextPrimary, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "View Credential",
                        color = AccentBlue,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.clickable {
                            onShowToast("hi")
                        }
                    )
                }
            }
        }
        item {
            PortfolioCard("Education") {
                state.education.forEachIndexed { index, edu ->
                    Column {
                        Text(edu.degree, color = Color.White, fontWeight = FontWeight.Bold)
                        Text(edu.major, color = TextPrimary)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(edu.institution, color = TextSecondary)
                        Text("${edu.location} | ${edu.period}", color = TextSecondary)
                        if (index < state.education.size - 1) {
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
        item { Spacer(modifier = Modifier.height(20.dp)) }
    }
}
