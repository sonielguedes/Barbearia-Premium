package com.barbeariapremium.app.ui.splash

import android.view.animation.DecelerateInterpolator
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNext: () -> Unit) {
    var startAnimation by remember { mutableStateOf(false) }
    
    // Animação de Opacidade
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 1500, easing = FastOutSlowInEasing),
        label = "alpha"
    )

    // Animação de Escala (Efeito de aproximação "Cinematográfico")
    val scaleAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1.1f else 0.9f,
        animationSpec = tween(durationMillis = 2500, easing = LinearOutSlowInEasing),
        label = "scale"
    )

    // Animação de Deslocamento sutil para cima
    val offsetAnim = animateDpAsState(
        targetValue = if (startAnimation) 0.dp else 20.dp,
        animationSpec = tween(durationMillis = 1500, easing = DecelerateInterpolator().toEasing()),
        label = "offset"
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(3000) // Tempo maior para apreciar a animação premium
        onNext()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1A1A1A), // Cinza quase preto
                        Color.Black        // Preto absoluto
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .graphicsLayer(
                    alpha = alphaAnim.value,
                    scaleX = scaleAnim.value,
                    scaleY = scaleAnim.value,
                    translationY = offsetAnim.value.value
                )
        ) {
            // Linha decorativa dourada superior
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(2.dp)
                    .background(MaterialTheme.colorScheme.primary)
                    .alpha(0.7f)
            )
            
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "BARBEARIA",
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.primary, // Dourado Premium
                fontWeight = FontWeight.Black,
                letterSpacing = 12.sp
            )
            
            Text(
                text = "PREMIUM",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                fontWeight = FontWeight.ExtraLight,
                letterSpacing = 16.sp,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Linha decorativa dourada inferior
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(2.dp)
                    .background(MaterialTheme.colorScheme.primary)
                    .alpha(0.7f)
            )
        }
        
        // Versão do App sutil no rodapé
        Text(
            text = "EST. 2024",
            color = Color.DarkGray,
            fontSize = 10.sp,
            letterSpacing = 4.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
                .alpha(alphaAnim.value)
        )
    }
}

// Helper para converter interpolator em easing
fun android.view.animation.Interpolator.toEasing() = Easing { x -> getInterpolation(x) }
