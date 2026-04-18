package com.barbeariapremium.app.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010*\u001a\u00020+R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u001f\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u000f\u00a2\u0006\u000e\n\u0000\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0013R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0013R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0013\u00a8\u0006,"}, d2 = {"Lcom/barbeariapremium/app/ui/viewmodel/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/barbeariapremium/app/data/repository/AuthRepository;", "appointmentRepository", "Lcom/barbeariapremium/app/data/repository/AppointmentRepository;", "serviceRepository", "Lcom/barbeariapremium/app/data/repository/ServiceRepository;", "barberRepository", "Lcom/barbeariapremium/app/data/repository/BarberRepository;", "(Lcom/barbeariapremium/app/data/repository/AuthRepository;Lcom/barbeariapremium/app/data/repository/AppointmentRepository;Lcom/barbeariapremium/app/data/repository/ServiceRepository;Lcom/barbeariapremium/app/data/repository/BarberRepository;)V", "_user", "Lkotlinx/coroutines/flow/Flow;", "Lcom/barbeariapremium/app/data/model/User;", "barbers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/barbeariapremium/app/data/model/Barber;", "getBarbers", "()Lkotlinx/coroutines/flow/StateFlow;", "cashbackBalance", "", "getCashbackBalance", "currentUser", "Lcom/google/firebase/auth/FirebaseUser;", "getCurrentUser", "()Lcom/google/firebase/auth/FirebaseUser;", "loyaltyPoints", "", "getLoyaltyPoints", "nextAppointment", "Lcom/barbeariapremium/app/data/model/Appointment;", "getNextAppointment$annotations", "()V", "getNextAppointment", "popularServices", "Lcom/barbeariapremium/app/data/model/Service;", "getPopularServices", "userState", "getUserState", "userStatus", "getUserStatus", "fetchHomeData", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.repository.AppointmentRepository appointmentRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.repository.ServiceRepository serviceRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.repository.BarberRepository barberRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.barbeariapremium.app.data.model.User> _user = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.barbeariapremium.app.data.model.User> userState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> cashbackBalance = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> loyaltyPoints = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> userStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.barbeariapremium.app.data.model.Appointment> nextAppointment = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.Service>> popularServices = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.Barber>> barbers = null;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.repository.AuthRepository authRepository, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.repository.AppointmentRepository appointmentRepository, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.repository.ServiceRepository serviceRepository, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.repository.BarberRepository barberRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.firebase.auth.FirebaseUser getCurrentUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.barbeariapremium.app.data.model.User> getUserState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getCashbackBalance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getLoyaltyPoints() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getUserStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.barbeariapremium.app.data.model.Appointment> getNextAppointment() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    @java.lang.Deprecated()
    public static void getNextAppointment$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.Service>> getPopularServices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.Barber>> getBarbers() {
        return null;
    }
    
    public final void fetchHomeData() {
    }
}