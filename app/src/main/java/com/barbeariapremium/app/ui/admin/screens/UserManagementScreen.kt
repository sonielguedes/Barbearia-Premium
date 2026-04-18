package com.barbeariapremium.app.ui.admin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.barbeariapremium.app.data.model.User
import com.barbeariapremium.app.ui.theme.*
import com.barbeariapremium.app.ui.viewmodel.AdminViewModel
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserManagementScreen(
    viewModel: AdminViewModel,
    onNavigateBack: () -> Unit
) {
    val users by viewModel.users.collectAsState()
    var searchQuery by remember { mutableStateOf("") }
    
    val filteredUsers = users.filter { 
        it.name.contains(searchQuery, ignoreCase = true) || it.email.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(
                        "GESTÃO DE CLIENTES", 
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
                .padding(horizontal = 24.dp)
        ) {
            // Barra de Busca
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                placeholder = { Text("Buscar por nome ou e-mail", color = GreyLight) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = GoldPrimary) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = GoldPrimary,
                    unfocusedBorderColor = GreyMedium,
                    focusedTextColor = WhitePremium,
                    unfocusedTextColor = WhitePremium,
                    cursorColor = GoldPrimary
                ),
                shape = RoundedCornerShape(12.dp)
            )

            Text(
                "${filteredUsers.size} CLIENTES ENCONTRADOS",
                style = MaterialTheme.typography.labelSmall.copy(color = GreyLight, letterSpacing = 2.sp),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 32.dp)
            ) {
                items(filteredUsers) { user ->
                    UserAdminCard(user)
                }
            }
        }
    }
}

@Composable
fun UserAdminCard(user: User) {
    val statusUpper = user.status.uppercase()
    val nameInitial = if (user.name.length > 0) user.name[0].toString().uppercase() else "?"
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(0.5.dp, GreyMedium.copy(alpha = 0.5f), RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(SurfaceDark)
                    .border(1.dp, GoldPrimary.copy(alpha = 0.3f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    nameInitial,
                    color = GoldPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    user.name,
                    color = WhitePremium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    user.email,
                    color = GreyLight,
                    fontSize = 12.sp
                )
                
                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Badge de Status
                    Surface(
                        color = when(statusUpper) {
                            "DIAMOND" -> Color(0xFFB9F2FF)
                            "GOLD" -> GoldPrimary
                            "SILVER" -> Color(0xFFC0C0C0)
                            else -> Color(0xFFCD7F32)
                        },
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            statusUpper,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                            color = Color.Black,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Black
                        )
                    }
                    
                    Spacer(modifier = Modifier.width(12.dp))
                    
                    Icon(Icons.Default.Star, contentDescription = null, tint = GoldPrimary, modifier = Modifier.size(14.dp))
                    Text(
                        " ${user.loyaltyPoints} pts",
                        color = GreyLight,
                        fontSize = 12.sp
                    )
                }
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    "Cashback",
                    color = GreyLight,
                    fontSize = 10.sp
                )
                Text(
                    "R$ ${"%.2f".format(user.cashbackAmount)}",
                    color = GreenSuccess,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}
