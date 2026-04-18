package com.barbeariapremium.app.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\"J\u0010\u0010&\u001a\u00020\"2\u0006\u0010\'\u001a\u00020$H\u0002J\u0006\u0010(\u001a\u00020\nJ\u0016\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020$J\u0006\u0010,\u001a\u00020\"J\u0016\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\r2\u0006\u0010+\u001a\u00020$J&\u0010-\u001a\u00020\"2\u0006\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020$2\u0006\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020$R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016\u00a8\u00061"}, d2 = {"Lcom/barbeariapremium/app/ui/viewmodel/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/barbeariapremium/app/data/repository/AuthRepository;", "appointmentRepository", "Lcom/barbeariapremium/app/data/repository/AppointmentRepository;", "(Lcom/barbeariapremium/app/data/repository/AuthRepository;Lcom/barbeariapremium/app/data/repository/AppointmentRepository;)V", "_authState", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "", "_currentUser", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/barbeariapremium/app/data/model/User;", "_loading", "authState", "Landroidx/lifecycle/LiveData;", "getAuthState", "()Landroidx/lifecycle/LiveData;", "currentUser", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentUser", "()Lkotlinx/coroutines/flow/StateFlow;", "firebaseUser", "Lcom/google/firebase/auth/FirebaseUser;", "getFirebaseUser", "()Lcom/google/firebase/auth/FirebaseUser;", "loading", "getLoading", "userAppointments", "", "Lcom/barbeariapremium/app/data/model/Appointment;", "getUserAppointments", "cancelAppointment", "", "appointmentId", "", "fetchUserAppointments", "fetchUserData", "uid", "isUserLoggedIn", "login", "email", "password", "logout", "register", "user", "name", "phone", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.repository.AuthRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.repository.AppointmentRepository appointmentRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<kotlin.Result<java.lang.Boolean>> _authState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<kotlin.Result<java.lang.Boolean>> authState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _loading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> loading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.barbeariapremium.app.data.model.User> _currentUser = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.barbeariapremium.app.data.model.User> currentUser = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.Appointment>> userAppointments = null;
    
    @javax.inject.Inject()
    public AuthViewModel(@org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.repository.AuthRepository repository, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.repository.AppointmentRepository appointmentRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<kotlin.Result<java.lang.Boolean>> getAuthState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.barbeariapremium.app.data.model.User> getCurrentUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.Appointment>> getUserAppointments() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.firebase.auth.FirebaseUser getFirebaseUser() {
        return null;
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    public final boolean isUserLoggedIn() {
        return false;
    }
    
    public final void register(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String phone) {
    }
    
    public final void register(@org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.model.User user, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    private final void fetchUserData(java.lang.String uid) {
    }
    
    public final void fetchUserAppointments() {
    }
    
    public final void cancelAppointment(@org.jetbrains.annotations.NotNull()
    java.lang.String appointmentId) {
    }
    
    public final void logout() {
    }
}