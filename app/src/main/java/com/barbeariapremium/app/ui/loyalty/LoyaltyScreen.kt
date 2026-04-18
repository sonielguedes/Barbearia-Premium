package com.barbeariapremium.app.ui.loyalty

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ContentCut
import androidx.compose.material.icons.filled.Stars
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.barbeariapremium.app.ui.viewmodel.HomeViewModel
import com.barbeariapremium.app.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoyaltyScreen(
    viewModel: HomeViewModel,
    onNavigateBack: () -> Unit
) {
    val currentPoints by viewModel.loyaltyPoints.collectAsState()

    // Configuração da animação de brilho
    val infiniteTransition = rememberInfiniteTransition(label = "shimmer")
    val shimmerTranslateAnim by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 2000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmerTranslate"
    )

    val shimmerBrush = Brush.linearGradient(
        colors = listOf(
            Color.Transparent,
            GoldPrimary.copy(alpha = 0.05f),
            GoldPrimary.copy(alpha = 0.2f),
            GoldPrimary.copy(alpha = 0.05f),
            Color.Transparent,
        ),
        start = Offset(shimmerTranslateAnim - 500f, shimmerTranslateAnim - 500f),
        end = Offset(shimmerTranslateAnim, shimmerTranslateAnim),
        tileMode = TileMode.Clamp
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(
                        "CLUBE DE FIDELIDADE", 
                        style = MaterialTheme.typography.labelLarge.copy(letterSpacing = 4.sp, color = GoldPrimary)
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar", tint = WhitePremium)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = BlackMatte)
            )
        },
        containerColor = BlackMatte
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Brush.verticalGradient(listOf(BlackMatte, SurfaceDark)))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Cartão de Metal Digital
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(
                        Brush.linearGradient(
                            listOf(Color(0xFF2C2C2E), Color(0xFF1C1C1E), Color(0xFF2C2C2E))
                        )
                    )
                    .border(0.5.dp, GoldPrimary.copy(alpha = 0.4f), RoundedCornerShape(24.dp))
            ) {
                // Camada de Brilho Animada
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(shimmerBrush)
                )

                Column(modifier = Modifier.padding(24.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "ELITE MEMBER",
                            style = MaterialTheme.typography.labelSmall.copy(color = GoldPrimary, letterSpacing = 2.sp)
                        )
                        Icon(Icons.Default.Stars, contentDescription = null, tint = GoldPrimary)
                    }
                    
                    Spacer(modifier = Modifier.weight(1f))
                    
                    Text(
                        "STATUS DO CARTÃO",
                        style = MaterialTheme.typography.labelSmall.copy(color = GreyLight)
                    )
                    Text(
                        "$currentPoints / 10 SELOS",
                        style = MaterialTheme.typography.headlineMedium.copy(color = WhitePremium, fontWeight = FontWeight.ExtraBold)
                    )
                    
                    LinearProgressIndicator(
                        progress = currentPoints / 10f,
                        modifier = Modifier.fillMaxWidth().padding(top = 12.dp).height(8.dp).clip(CircleShape),
                        color = GoldPrimary,
                        trackColor = GreyMedium
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                "SUA JORNADA PREMIUM",
                style = MaterialTheme.typography.labelLarge.copy(color = WhitePremium, letterSpacing = 2.sp)
            )
            Text(
                "A cada 10 serviços, ganhe uma Experiência Master (Corte + Barba + Hidratação) totalmente grátis.",
                style = MaterialTheme.typography.bodyMedium.copy(color = GreyLight, textAlign = TextAlign.Center),
                modifier = Modifier.padding(vertical = 12.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Grid de Selos
            LazyVerticalGrid(
                columns = GridCells.Fixed(5),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(10) { index ->
                    val isEarned = index < currentPoints
                    Box(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .clip(CircleShape)
                            .background(if (isEarned) GoldPrimary else SurfaceDark)
                            .border(1.dp, if (isEarned) Color.Transparent else GreyMedium, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.ContentCut,
                            contentDescription = null,
                            tint = if (isEarned) BlackMatte else GreyMedium,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            PremiumButton(
                text = "RESGATAR RECOMPENSA",
                onClick = { /* Só habilita se pontos == 10 */ },
                enabled = currentPoints >= 10
            )
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
