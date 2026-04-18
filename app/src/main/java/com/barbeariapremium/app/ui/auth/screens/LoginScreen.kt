package com.barbeariapremium.app.ui.auth.screens

import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.barbeariapremium.app.ui.theme.*
import com.barbeariapremium.app.ui.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    viewModel: AuthViewModel,
    onLoginSuccess: () -> Unit,
    onNavigateToRegister: () -> Unit,
    onNavigateToAdmin: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loading by viewModel.loading.observeAsState(initial = false)
    val authState by viewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState) {
        authState?.let { result ->
            if (result.isSuccess) {
                onLoginSuccess()
            } else {
                val errorMsg = result.exceptionOrNull()?.message ?: "Erro na autenticação"
                Toast.makeText(context, errorMsg, Toast.LENGTH_LONG).show()
            }
        }
    }

    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(BlackMatte, SurfaceDark, BlackMatte)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGradient)
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo Premium
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "BARBERPRO",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        color = GoldPrimary,
                        letterSpacing = 6.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                Text(
                    text = "ELITE EXPERIENCE",
                    style = MaterialTheme.typography.labelLarge.copy(
                        color = WhitePremium.copy(alpha = 0.6f),
                        letterSpacing = 8.sp,
                        fontWeight = FontWeight.Light
                    )
                )
            }

            Spacer(modifier = Modifier.height(64.dp))

            // Formulário com Premium Components
            PremiumTextField(
                value = email,
                onValueChange = { email = it },
                label = "E-mail ou Usuário",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(16.dp))

            PremiumTextField(
                value = password,
                onValueChange = { password = it },
                label = "Senha de Acesso",
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                TextButton(onClick = { /* Recovery */ }) {
                    Text(
                        text = "Esqueceu sua senha?",
                        style = MaterialTheme.typography.labelMedium.copy(color = GoldPrimary)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            if (loading) {
                CircularProgressIndicator(color = GoldPrimary, modifier = Modifier.size(32.dp))
            } else {
                PremiumButton(
                    text = "Acessar Clube",
                    onClick = {
                        if (email.isNotEmpty() && password.isNotEmpty()) {
                            viewModel.login(email, password)
                        } else {
                            Toast.makeText(context, "Insira suas credenciais", Toast.LENGTH_SHORT).show()
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Divisor Sutil
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Box(modifier = Modifier.weight(1f).height(0.5.dp).background(GreyMedium))
                Text(
                    "  ACESSO RÁPIDO  ",
                    style = MaterialTheme.typography.labelSmall.copy(color = GreyLight, letterSpacing = 2.sp)
                )
                Box(modifier = Modifier.weight(1f).height(0.5.dp).background(GreyMedium))
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Biometria & Redes Sociais
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /* Biometria */ },
                    modifier = Modifier
                        .size(64.dp)
                        .background(SurfaceDark, RoundedCornerShape(16.dp))
                ) {
                    Icon(
                        imageVector = Icons.Default.Fingerprint,
                        contentDescription = "Biometria",
                        tint = GoldPrimary,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(48.dp))

            TextButton(onClick = onNavigateToRegister) {
                Text(
                    text = "Ainda não é membro? ",
                    style = MaterialTheme.typography.bodyMedium.copy(color = GreyLight)
                )
                Text(
                    text = "ASSOCIE-SE",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = GoldPrimary,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            TextButton(onClick = onNavigateToAdmin) {
                Text(
                    text = "ACESSO ADMINISTRATIVO",
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = GreyLight.copy(alpha = 0.5f),
                        letterSpacing = 2.sp
                    )
                )
            }
        }
    }
}
