package com.mathan.portfolio.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.WorkOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mathan.portfolio.store.AppState
import com.mathan.portfolio.store.Screen
import com.mathan.portfolio.viewmodel.AppViewModel
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(viewModel: AppViewModel) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        containerColor = Color.Transparent // Background is handled by the Box below
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundDark)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            ) {
                Spacer(modifier = Modifier.height(60.dp))
                if (!state.toastMessage.isNullOrEmpty()) {
                    LaunchedEffect(state.toastMessage) {
                        delay(3000)
                        viewModel.clearToast()
                    }
                    Text(
                        text = state.toastMessage!!,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(8.dp))
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
                HeaderSection(state)
                Spacer(modifier = Modifier.height(24.dp))

                Box(modifier = Modifier.weight(1f)) {
                    AnimatedContent(
                        targetState = state.selectedScreen,
                        transitionSpec = {
                            fadeIn(animationSpec = tween(500)) togetherWith 
                            fadeOut(animationSpec = tween(500))
                        }
                    ) { targetScreen ->
                        when (targetScreen) {
                            Screen.About -> AboutTab(state)
                            Screen.Skills -> SkillsTab(state)
                            Screen.Work -> WorkTab(state)
                            Screen.Projects -> ProjectsTab(state)
                            Screen.Others -> OthersTab(state, onShowToast = { viewModel.showToast(it) })
                        }
                    }
                }
                
                PortfolioBottomBar(
                    selectedScreen = state.selectedScreen,
                    onScreenSelected = { viewModel.selectScreen(it) }
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun HeaderSection(state: AppState) {
    Column {
        Text(
            text = state.name,
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = state.role,
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = state.location,
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary
        )
    }
}

@Composable
fun PortfolioBottomBar(
    selectedScreen: Screen,
    onScreenSelected: (Screen) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(CardBackground)
            .border(1.dp, Color(0xFF30363D), RoundedCornerShape(24.dp))
            .padding(vertical = 8.dp, horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Screen.values().forEach { screen ->
            val isSelected = selectedScreen == screen
            val icon = when (screen) {
                Screen.About -> if (isSelected) Icons.Filled.Person else Icons.Outlined.Person
                Screen.Skills -> if (isSelected) Icons.Filled.Star else Icons.Outlined.Star
                Screen.Work -> if (isSelected) Icons.Filled.Work else Icons.Outlined.WorkOutline
                Screen.Projects -> if (isSelected) Icons.Filled.GridView else Icons.Outlined.GridView
                Screen.Others -> if (isSelected) Icons.Filled.Menu else Icons.Outlined.Menu
            }

            val contentColor by animateColorAsState(
                targetValue = if (isSelected) AccentBlue else TextSecondary,
                animationSpec = tween(durationMillis = 300)
            )

            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .then(
                        if (isSelected) Modifier
                            .background(Color(0xFF1F242C))
                            .border(1.dp, AccentBlue.copy(alpha = 0.5f), RoundedCornerShape(16.dp)) 
                        else Modifier
                    )
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = { onScreenSelected(screen) }
                    )
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = screen.name,
                    tint = contentColor,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = screen.name,
                    color = if (isSelected) Color.White else TextSecondary,
                    fontSize = 10.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    }
}
