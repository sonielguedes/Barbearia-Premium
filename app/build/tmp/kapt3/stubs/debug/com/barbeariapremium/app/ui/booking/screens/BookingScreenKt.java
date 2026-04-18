package com.barbeariapremium.app.ui.booking.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u001a4\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007\u001a,\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007\u001a\u0018\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0007\u001a4\u0010\u0015\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00172\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001aF\u0010\u0018\u001a\u00020\u0001*\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007\u001a`\u0010!\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00132\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007\u00a8\u0006\'"}, d2 = {"BarberSelection", "", "barbers", "", "Lcom/barbeariapremium/app/data/model/Barber;", "selected", "onSelect", "Lkotlin/Function1;", "BookingProgress", "currentStep", "", "BookingScreen", "viewModel", "Lcom/barbeariapremium/app/ui/viewmodel/BookingViewModel;", "onBookingComplete", "Lkotlin/Function0;", "onNavigateBack", "DetailRowPremium", "label", "", "value", "ServiceSelection", "services", "Lcom/barbeariapremium/app/data/model/Service;", "ConfirmationStep", "Landroidx/compose/foundation/layout/ColumnScope;", "service", "barber", "date", "time", "loading", "", "onConfirm", "DateTimeSelection", "selectedDate", "selectedTime", "availableTimes", "onDateSelect", "onTimeSelect", "app_debug"})
@kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
public final class BookingScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void BookingScreen(@org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.ui.viewmodel.BookingViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBookingComplete, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void BookingProgress(int currentStep) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ServiceSelection(@org.jetbrains.annotations.NotNull()
    java.util.List<com.barbeariapremium.app.data.model.Service> services, @org.jetbrains.annotations.Nullable()
    com.barbeariapremium.app.data.model.Service selected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.barbeariapremium.app.data.model.Service, kotlin.Unit> onSelect) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void BarberSelection(@org.jetbrains.annotations.NotNull()
    java.util.List<com.barbeariapremium.app.data.model.Barber> barbers, @org.jetbrains.annotations.Nullable()
    com.barbeariapremium.app.data.model.Barber selected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.barbeariapremium.app.data.model.Barber, kotlin.Unit> onSelect) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DateTimeSelection(@org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.layout.ColumnScope $this$DateTimeSelection, @org.jetbrains.annotations.NotNull()
    java.lang.String selectedDate, @org.jetbrains.annotations.NotNull()
    java.lang.String selectedTime, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> availableTimes, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDateSelect, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onTimeSelect, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onConfirm) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ConfirmationStep(@org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.layout.ColumnScope $this$ConfirmationStep, @org.jetbrains.annotations.Nullable()
    com.barbeariapremium.app.data.model.Service service, @org.jetbrains.annotations.Nullable()
    com.barbeariapremium.app.data.model.Barber barber, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.lang.String time, boolean loading, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onConfirm) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DetailRowPremium(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
}