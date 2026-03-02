package com.mathan.portfolio.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mathan.portfolio.store.AppState

@Composable
fun AboutTab(state: AppState) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.fillMaxSize()) {
        item {
            PortfolioCard("About") {
                Text(state.aboutSummary, color = TextSecondary, lineHeight = 20.sp)
                Spacer(modifier = Modifier.height(16.dp))
                state.aboutBulletPoints.forEach { bullet ->
                    Row(modifier = Modifier.padding(vertical = 4.dp)) {
                        Text("•", color = AccentBlue, modifier = Modifier.padding(end = 8.dp))
                        Text(bullet, color = TextSecondary, lineHeight = 20.sp)
                    }
                }
            }
        }
        item {
            PortfolioCard("Contact") {
                ContactItem(Icons.Default.Email, state.contact.email)
                ContactItem(Icons.Default.Phone, state.contact.phone)
                ContactItem(Icons.Default.Link, state.contact.linkedin)
                ContactItem(Icons.Default.Code, state.contact.github)
            }
        }
        item { Spacer(modifier = Modifier.height(20.dp)) }
    }
}
