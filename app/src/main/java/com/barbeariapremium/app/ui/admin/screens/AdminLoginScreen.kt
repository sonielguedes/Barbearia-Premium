package com.barbeariapremium.app.ui.admin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.barbeariapremium.app.ui.theme.*
import com.barbeariapremium.app.ui.viewmodel.AuthViewModel

@Composable
fun AdminLoginScreen(
    viewModel: AuthViewModel,
    onAdminLoginSuccess: () -> Unit,
    onNavigateBack: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var adminKey by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color.Black, SurfaceDark)))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Security,
                contentDescription = null,
                tint = GoldPrimary,
                modifier = Modifier.size(64.dp)
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Text(
                "ADMIN ACCESS",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = WhitePremium,
                    fontWeight = FontWeight.Black,
                    letterSpacing = 8.sp
                )
            )
            
            Text(
                "SISTEMA DE GESTÃO ELITE",
                style = MaterialTheme.typography.labelSmall.copy(color = GoldPrimary, letterSpacing = 2.sp)
            )

            Spacer(modifier = Modifier.height(48.dp))

            PremiumTextField(
                value = email,
                onValueChange = { email = it },
                label = "E-mail Administrativo"
            )
            
            Spacer(modifier = Modifier.height(16.dp))

            PremiumTextField(
                value = password,
                onValueChange = { password = it },
                label = "Senha",
                visualTransformation = PasswordVisualTransformation()
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            PremiumTextField(
                value = adminKey,
                onValueChange = { adminKey = it },
                label = "Chave de Acesso Master",
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(32.dp))

            PremiumButton(
                text = "AUTENTICAR",
                onClick = {
                    // Lógica: No Firebase, verificaríamos se o user tem a flag isAdmin
                    // Para o MVP, validamos os campos
                    if (email.isNotEmpty() && password.isNotEmpty() && adminKey == "1234") {
                        viewModel.login(email, password)
                        onAdminLoginSuccess()
                    }
                }
            )
            
            TextButton(onClick = onNavigateBack) {
                Text("VOLTAR AO APP CLIENTE", color = GreyLight)
            }
        }
    }
}
