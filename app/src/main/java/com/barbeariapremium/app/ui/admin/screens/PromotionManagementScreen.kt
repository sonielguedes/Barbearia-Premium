package com.barbeariapremium.app.ui.admin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.barbeariapremium.app.data.model.Promotion
import com.barbeariapremium.app.ui.theme.*
import com.barbeariapremium.app.ui.viewmodel.AdminViewModel
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromotionManagementScreen(
    onNavigateBack: () -> Unit,
    viewModel: AdminViewModel = hiltViewModel()
) {
    val promotionsList by viewModel.promotions.collectAsState()
    var showAddDialog by remember { mutableStateOf(false) }

    val banners = remember(promotionsList) { promotionsList.filter { it.type == "BANNER" } }
    val coupons = remember(promotionsList) { promotionsList.filter { it.type == "COUPON" } }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(
                        "GESTÃO PREMIUM", 
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
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true },
                containerColor = GoldPrimary,
                contentColor = BlackMatte,
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Nova Promoção")
            }
        },
        containerColor = BlackMatte
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Brush.verticalGradient(listOf(BlackMatte, SurfaceDark)))
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(top = 16.dp, bottom = 100.dp)
        ) {
            if (banners.isNotEmpty()) {
                item { SectionHeader("BANNERS DE DESTAQUE") }
                items(items = banners, key = { it.id }) { banner ->
                    PremiumPromotionCard(banner) { viewModel.togglePromotion(banner.id, it) }
                }
            }
            
            if (coupons.isNotEmpty()) {
                item { 
                    Spacer(modifier = Modifier.height(8.dp))
                    SectionHeader("CUPONS DE FIDELIDADE") 
                }
                items(items = coupons, key = { it.id }) { coupon ->
                    PremiumPromotionCard(coupon) { viewModel.togglePromotion(coupon.id, it) }
                }
            }

            if (promotionsList.isEmpty()) {
                item { EmptyPromotionsState() }
            }
        }
    }

    if (showAddDialog) {
        PremiumAddPromotionDialog(
            onDismiss = { showAddDialog = false },
            onConfirm = { 
                viewModel.addPromotion(it)
                showAddDialog = false
            }
        )
    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.labelSmall.copy(
            color = GreyLight,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
fun PremiumPromotionCard(promotion: Promotion, onToggle: (Boolean) -> Unit) {
    PremiumCard {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Brush.linearGradient(listOf(GoldDark, GoldPrimary))),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (promotion.type == "BANNER") Icons.Default.AutoAwesome else Icons.Default.ConfirmationNumber,
                    contentDescription = null,
                    tint = BlackMatte,
                    modifier = Modifier.size(24.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(promotion.title, color = WhitePremium, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(promotion.description, color = GreyLight, fontSize = 13.sp)
                if (promotion.couponCode != null) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Surface(
                        color = GoldPrimary.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = promotion.couponCode!!,
                            color = GoldPrimary,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                        )
                    }
                }
            }
            
            Switch(
                checked = promotion.isActive,
                onCheckedChange = onToggle,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = GoldPrimary,
                    checkedTrackColor = GoldPrimary.copy(alpha = 0.3f),
                    uncheckedThumbColor = GreyMedium,
                    uncheckedTrackColor = SurfaceDark
                )
            )
        }
    }
}

@Composable
fun PremiumAddPromotionDialog(onDismiss: () -> Unit, onConfirm: (Promotion) -> Unit) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var discount by remember { mutableStateOf("") }
    var code by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("BANNER") }

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = SurfaceDark,
        titleContentColor = GoldPrimary,
        textContentColor = WhitePremium,
        title = { Text("NOVA OFERTA ELITE", style = MaterialTheme.typography.titleMedium.copy(letterSpacing = 2.sp)) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                PremiumTextField(value = title, onValueChange = { title = it }, label = "Título da Campanha")
                PremiumTextField(value = description, onValueChange = { description = it }, label = "Descrição")
                PremiumTextField(value = discount, onValueChange = { discount = it }, label = "% de Desconto")
                
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = type == "BANNER", 
                        onClick = { type = "BANNER" },
                        colors = RadioButtonDefaults.colors(selectedColor = GoldPrimary)
                    )
                    Text("Banner", color = WhitePremium)
                    Spacer(modifier = Modifier.width(16.dp))
                    RadioButton(
                        selected = type == "COUPON", 
                        onClick = { type = "COUPON" },
                        colors = RadioButtonDefaults.colors(selectedColor = GoldPrimary)
                    )
                    Text("Cupom", color = WhitePremium)
                }

                if (type == "COUPON") {
                    PremiumTextField(value = code, onValueChange = { code = it }, label = "Código Exclusivo")
                }
            }
        },
        confirmButton = {
            TextButton(onClick = {
                val promotion = Promotion(
                    id = UUID.randomUUID().toString(),
                    title = title,
                    description = description,
                    discountPercentage = (discount.toIntOrNull() ?: 0),
                    couponCode = if (type == "COUPON") code else null,
                    type = type,
                    isActive = true
                )
                onConfirm(promotion)
            }) {
                Text("CRIAR AGORA", color = GoldPrimary, fontWeight = FontWeight.Bold)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("CANCELAR", color = GreyLight) }
        }
    )
}

@Composable
fun EmptyPromotionsState() {
    Column(
        modifier = Modifier.fillMaxWidth().height(300.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(Icons.Default.Inventory2, contentDescription = null, modifier = Modifier.size(64.dp), tint = GreyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Nenhuma campanha ativa no momento.", color = GreyLight)
    }
}
