package com.barbeariapremium.app.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = GoldPrimary,
    onPrimary = BlackMatte,
    secondary = GoldDark,
    onSecondary = WhitePremium,
    tertiary = GoldLight,
    background = BlackMatte,
    surface = SurfaceDark,
    onBackground = WhitePremium,
    onSurface = WhitePremium,
    surfaceVariant = CardDark,
    onSurfaceVariant = GreyLight,
    error = RedError,
    outline = GreyMedium
)

// Apps Premium geralmente focam no Dark Mode, mas mantemos o Light para acessibilidade
private val LightColorScheme = lightColorScheme(
    primary = GoldPrimary,
    onPrimary = BlackMatte,
    secondary = GoldDark,
    onSecondary = WhitePremium,
    tertiary = GoldLight,
    background = WhitePremium,
    surface = Color.White,
    onBackground = BlackMatte,
    onSurface = BlackMatte,
    surfaceVariant = Color(0xFFF2F2F7),
    onSurfaceVariant = GreyMedium,
    error = RedError,
    outline = GreyLight
)

@Composable
fun BarberProTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Para um visual "milionário", podemos forçar o Dark Mode ou apenas otimizá-lo
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current
    
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            window.navigationBarColor = colorScheme.background.toArgb()
            
            val controller = WindowCompat.getInsetsController(window, view)
            controller.isAppearanceLightStatusBars = !darkTheme
            controller.isAppearanceLightNavigationBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
