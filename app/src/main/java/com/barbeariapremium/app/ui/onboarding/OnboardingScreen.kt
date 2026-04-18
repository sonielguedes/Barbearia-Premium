package com.barbeariapremium.app.ui.onboarding

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.barbeariapremium.app.ui.components.PremiumButton
import kotlinx.coroutines.launch

data class OnboardingPageData(
    val title: String,
    val description: String,
    val highlight: String
)

private val onboardingPagesList = listOf(
    OnboardingPageData("EXPERIÊNCIA", "Transforme seu visual com os melhores especialistas da região.", "EXCLUSIVA"),
    OnboardingPageData("AGENDAMENTO", "Reserve seu horário em segundos com confirmação em tempo real.", "INTELIGENTE"),
    OnboardingPageData("CLUB VIP", "Acumule cashback e pontos de fidelidade a cada serviço realizado.", "PREMIUM")
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(onFinish: () -> Unit) {
    val pagerState = rememberPagerState(pageCount = { onboardingPagesList.size })
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Background Gradient Sutil
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF1A1A1A), Color.Black)
                    )
                )
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { index ->
                OnboardingContent(onboardingPagesList[index])
            }

            // Indicadores e Botões
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    Modifier.height(8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in onboardingPagesList.indices) {
                        val isSelected = pagerState.currentPage == i
                        val color = if (isSelected) MaterialTheme.colorScheme.primary else Color.DarkGray
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 4.dp)
                                .clip(CircleShape)
                                .background(color)
                                .size(if (isSelected) 10.dp else 6.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(48.dp))

                val isLastPage = pagerState.currentPage == onboardingPagesList.size - 1

                PremiumButton(
                    text = if (isLastPage) "COMEÇAR AGORA" else "PRÓXIMO",
                    onClick = {
                        if (isLastPage) {
                            onFinish()
                        } else {
                            scope.launch {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1,
                                    animationSpec = tween(600, easing = FastOutSlowInEasing)
                                )
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                
                TextButton(onClick = onFinish) {
                    Text("Pular", color = Color.Gray)
                }
            }
        }
    }
}

@Composable
fun OnboardingContent(page: OnboardingPageData) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = page.highlight,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelLarge,
            letterSpacing = 4.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = page.title,
            color = Color.White,
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = page.description,
            color = Color.LightGray,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            lineHeight = 28.sp
        )
    }
}
