package com.barbeariapremium.app.ui.admin.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a<\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007\u001a<\u0010\u000b\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032$\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a(\u0010\u0013\u001a\u00020\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u0010\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a*\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007\u00a8\u0006\u001e"}, d2 = {"AdminScreen", "", "onNavigateBack", "Lkotlin/Function0;", "onNavigateToBarbers", "onNavigateToPromotions", "viewModel", "Lcom/barbeariapremium/app/ui/viewmodel/AdminViewModel;", "AppointmentAdminCard", "appointment", "Lcom/barbeariapremium/app/data/model/Appointment;", "BlockScheduleDialog", "onDismiss", "onConfirm", "Lkotlin/Function4;", "", "CustomerStatItem", "customer", "Lcom/barbeariapremium/app/ui/viewmodel/CustomerRanking;", "QuickActionRow", "ServiceStatItem", "service", "Lcom/barbeariapremium/app/ui/viewmodel/ServiceStats;", "StatCard", "title", "value", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "modifier", "Landroidx/compose/ui/Modifier;", "app_debug"})
public final class AdminScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void AdminScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToBarbers, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToPromotions, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.ui.viewmodel.AdminViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void StatCard(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AppointmentAdminCard(@org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.model.Appointment appointment) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ServiceStatItem(@org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.ui.viewmodel.ServiceStats service) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CustomerStatItem(@org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.ui.viewmodel.CustomerRanking customer) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void QuickActionRow(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToBarbers, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToPromotions) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void BlockScheduleDialog(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, kotlin.Unit> onConfirm) {
    }
}