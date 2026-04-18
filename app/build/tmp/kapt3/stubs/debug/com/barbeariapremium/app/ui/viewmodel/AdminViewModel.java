package com.barbeariapremium.app.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020&J\u000e\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u0010J&\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020$J$\u0010/\u001a\u00020\"2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0002J\u000e\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020$J\u000e\u00103\u001a\u00020\"2\u0006\u00104\u001a\u000205J\b\u00106\u001a\u00020\"H\u0002J\b\u00107\u001a\u00020\"H\u0002J\b\u00108\u001a\u00020\"H\u0002J\b\u00109\u001a\u00020\"H\u0002J\u000e\u0010:\u001a\u00020\"2\u0006\u0010;\u001a\u00020\u000eJ\u0016\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020?R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000b0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018\u00a8\u0006@"}, d2 = {"Lcom/barbeariapremium/app/ui/viewmodel/AdminViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/barbeariapremium/app/data/repository/AuthRepository;", "appointmentRepository", "Lcom/barbeariapremium/app/data/repository/AppointmentRepository;", "barberRepository", "Lcom/barbeariapremium/app/data/repository/BarberRepository;", "(Lcom/barbeariapremium/app/data/repository/AuthRepository;Lcom/barbeariapremium/app/data/repository/AppointmentRepository;Lcom/barbeariapremium/app/data/repository/BarberRepository;)V", "_allAppointments", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/barbeariapremium/app/data/model/Appointment;", "_barbers", "Lcom/barbeariapremium/app/data/model/Barber;", "_promotions", "Lcom/barbeariapremium/app/data/model/Promotion;", "_stats", "Lcom/barbeariapremium/app/ui/viewmodel/DashboardStats;", "_users", "Lcom/barbeariapremium/app/data/model/User;", "allAppointments", "Lkotlinx/coroutines/flow/StateFlow;", "getAllAppointments", "()Lkotlinx/coroutines/flow/StateFlow;", "barbers", "getBarbers", "promotions", "getPromotions", "stats", "getStats", "users", "getUsers", "addNewBarber", "", "name", "", "commissionRate", "", "monthlyGoal", "addPromotion", "promotion", "blockSchedule", "barberId", "barberName", "date", "time", "calculateStats", "appointments", "deleteBarber", "id", "generateMonthlyReport", "context", "Landroid/content/Context;", "loadBarbers", "loadDashboardData", "loadPromotions", "loadUsers", "saveBarber", "barber", "togglePromotion", "promotionId", "isActive", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AdminViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.repository.AppointmentRepository appointmentRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.repository.BarberRepository barberRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.barbeariapremium.app.data.model.User>> _users = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.User>> users = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.barbeariapremium.app.data.model.Barber>> _barbers = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.Barber>> barbers = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.barbeariapremium.app.ui.viewmodel.DashboardStats> _stats = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.barbeariapremium.app.ui.viewmodel.DashboardStats> stats = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.barbeariapremium.app.data.model.Appointment>> _allAppointments = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.Appointment>> allAppointments = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.barbeariapremium.app.data.model.Promotion>> _promotions = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.Promotion>> promotions = null;
    
    @javax.inject.Inject()
    public AdminViewModel(@org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.repository.AuthRepository authRepository, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.repository.AppointmentRepository appointmentRepository, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.repository.BarberRepository barberRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.User>> getUsers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.Barber>> getBarbers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.barbeariapremium.app.ui.viewmodel.DashboardStats> getStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.Appointment>> getAllAppointments() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.Promotion>> getPromotions() {
        return null;
    }
    
    private final void loadBarbers() {
    }
    
    public final void deleteBarber(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    public final void saveBarber(@org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.model.Barber barber) {
    }
    
    private final void loadUsers() {
    }
    
    private final void loadPromotions() {
    }
    
    private final void loadDashboardData() {
    }
    
    private final void calculateStats(java.util.List<com.barbeariapremium.app.data.model.Appointment> appointments, java.util.List<com.barbeariapremium.app.data.model.Barber> barbers) {
    }
    
    public final void addNewBarber(@org.jetbrains.annotations.NotNull()
    java.lang.String name, double commissionRate, double monthlyGoal) {
    }
    
    public final void blockSchedule(@org.jetbrains.annotations.NotNull()
    java.lang.String barberId, @org.jetbrains.annotations.NotNull()
    java.lang.String barberName, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.lang.String time) {
    }
    
    public final void addPromotion(@org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.model.Promotion promotion) {
    }
    
    public final void togglePromotion(@org.jetbrains.annotations.NotNull()
    java.lang.String promotionId, boolean isActive) {
    }
    
    public final void generateMonthlyReport(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
}