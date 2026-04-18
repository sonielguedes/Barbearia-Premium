package com.barbeariapremium.app.ui.auth.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    viewModel: AuthViewModel,
    onRegisterSuccess: () -> Unit,
    onNavigateBack: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    
    val loading by viewModel.loading.observeAsState(initial = false)
    val authState by viewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState) {
        authState?.let { result ->
            if (result.isSuccess) {
                onRegisterSuccess()
            } else {
                val errorMsg = result.exceptionOrNull()?.message ?: "Erro ao criar conta"
                Toast.makeText(context, errorMsg, Toast.LENGTH_LONG).show()
            }
        }
    }

    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(BlackMatte, SurfaceDark, BlackMatte)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TORNE-SE MEMBRO", style = MaterialTheme.typography.labelLarge.copy(letterSpacing = 2.sp)) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar", tint = WhitePremium)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BlackMatte, titleContentColor = GoldPrimary)
            )
        },
        containerColor = BlackMatte
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundGradient)
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "BEM-VINDO AO ELITE",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = WhitePremium,
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                Text(
                    text = "Preencha seus dados para acessar serviços exclusivos.",
                    style = MaterialTheme.typography.bodyMedium.copy(color = GreyLight),
                    modifier = Modifier.padding(top = 8.dp, bottom = 40.dp)
                )

                PremiumTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = "Nome Completo"
                )

                Spacer(modifier = Modifier.height(16.dp))

                PremiumTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = "E-mail Principal",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )

                Spacer(modifier = Modifier.height(16.dp))

                PremiumTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = "Telefone / WhatsApp",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )

                Spacer(modifier = Modifier.height(16.dp))

                PremiumTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = "Crie uma Senha",
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Spacer(modifier = Modifier.height(48.dp))

                if (loading) {
                    CircularProgressIndicator(color = GoldPrimary)
                } else {
                    PremiumButton(
                        text = "FINALIZAR ADMISSÃO",
                        onClick = {
                            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                                viewModel.register(email, password, name, phone)
                            } else {
                                Toast.makeText(context, "Preencha todos os campos obrigatórios", Toast.LENGTH_SHORT).show()
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
                
                Text(
                    text = "Ao se associar, você concorda com nossos termos de serviço premium.",
                    style = MaterialTheme.typography.labelSmall.copy(color = GreyMedium),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}
