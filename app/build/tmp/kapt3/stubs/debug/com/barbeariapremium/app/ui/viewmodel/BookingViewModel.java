package com.barbeariapremium.app.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u000e\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0012J\u0006\u0010:\u001a\u00020;J\u0006\u0010<\u001a\u000208J\b\u0010=\u001a\u000208H\u0002J\u0006\u0010>\u001a\u000208J\u000e\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00020\u0014J\u000e\u0010A\u001a\u0002082\u0006\u0010B\u001a\u00020\u0012J\u000e\u0010C\u001a\u0002082\u0006\u0010D\u001a\u00020\u001cJ\u000e\u0010E\u001a\u0002082\u0006\u0010F\u001a\u00020\u0012J\b\u0010G\u001a\u000208H\u0002R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00110\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00110\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0 \u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110 \u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00110 \u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00160 \u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160 \u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120 \u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0019\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140 \u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00120 \u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0019\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0 \u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120 \u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00110 \u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\"\u00a8\u0006H"}, d2 = {"Lcom/barbeariapremium/app/ui/viewmodel/BookingViewModel;", "Landroidx/lifecycle/ViewModel;", "appointmentRepository", "Lcom/barbeariapremium/app/data/repository/AppointmentRepository;", "serviceRepository", "Lcom/barbeariapremium/app/data/repository/ServiceRepository;", "barberRepository", "Lcom/barbeariapremium/app/data/repository/BarberRepository;", "authRepository", "Lcom/barbeariapremium/app/data/repository/AuthRepository;", "couponDao", "Lcom/barbeariapremium/app/data/local/dao/CouponDao;", "(Lcom/barbeariapremium/app/data/repository/AppointmentRepository;Lcom/barbeariapremium/app/data/repository/ServiceRepository;Lcom/barbeariapremium/app/data/repository/BarberRepository;Lcom/barbeariapremium/app/data/repository/AuthRepository;Lcom/barbeariapremium/app/data/local/dao/CouponDao;)V", "_appliedCoupon", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/barbeariapremium/app/data/model/Coupon;", "_availableTimes", "", "", "_barbers", "Lcom/barbeariapremium/app/data/model/Barber;", "_bookingLoading", "", "_bookingSuccess", "_couponError", "_selectedBarber", "_selectedDate", "_selectedService", "Lcom/barbeariapremium/app/data/model/Service;", "_selectedTime", "_services", "appliedCoupon", "Lkotlinx/coroutines/flow/StateFlow;", "getAppliedCoupon", "()Lkotlinx/coroutines/flow/StateFlow;", "availableTimes", "getAvailableTimes", "barbers", "getBarbers", "bookingLoading", "getBookingLoading", "bookingSuccess", "getBookingSuccess", "couponError", "getCouponError", "selectedBarber", "getSelectedBarber", "selectedDate", "getSelectedDate", "selectedService", "getSelectedService", "selectedTime", "getSelectedTime", "services", "getServices", "applyCoupon", "", "code", "calculateTotalPrice", "", "confirmBooking", "loadData", "removeCoupon", "selectBarber", "barber", "selectDate", "date", "selectService", "service", "selectTime", "time", "updateAvailableTimes", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class BookingViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.repository.AppointmentRepository appointmentRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.repository.ServiceRepository serviceRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.repository.BarberRepository barberRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.local.dao.CouponDao couponDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.barbeariapremium.app.data.model.Service>> _services = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.Service>> services = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.barbeariapremium.app.data.model.Barber>> _barbers = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.Barber>> barbers = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.barbeariapremium.app.data.model.Service> _selectedService = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.barbeariapremium.app.data.model.Service> selectedService = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.barbeariapremium.app.data.model.Barber> _selectedBarber = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.barbeariapremium.app.data.model.Barber> selectedBarber = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _selectedDate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> selectedDate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _selectedTime = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> selectedTime = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> _availableTimes = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> availableTimes = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _bookingLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> bookingLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _bookingSuccess = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> bookingSuccess = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.barbeariapremium.app.data.model.Coupon> _appliedCoupon = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.barbeariapremium.app.data.model.Coupon> appliedCoupon = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _couponError = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> couponError = null;
    
    @javax.inject.Inject()
    public BookingViewModel(@org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.repository.AppointmentRepository appointmentRepository, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.repository.ServiceRepository serviceRepository, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.repository.BarberRepository barberRepository, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.repository.AuthRepository authRepository, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.local.dao.CouponDao couponDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.Service>> getServices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.barbeariapremium.app.data.model.Barber>> getBarbers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.barbeariapremium.app.data.model.Service> getSelectedService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.barbeariapremium.app.data.model.Barber> getSelectedBarber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSelectedDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSelectedTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> getAvailableTimes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getBookingLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getBookingSuccess() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.barbeariapremium.app.data.model.Coupon> getAppliedCoupon() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getCouponError() {
        return null;
    }
    
    private final void loadData() {
    }
    
    public final void applyCoupon(@org.jetbrains.annotations.NotNull()
    java.lang.String code) {
    }
    
    public final void removeCoupon() {
    }
    
    public final double calculateTotalPrice() {
        return 0.0;
    }
    
    public final void selectService(@org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.model.Service service) {
    }
    
    public final void selectBarber(@org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.model.Barber barber) {
    }
    
    public final void selectDate(@org.jetbrains.annotations.NotNull()
    java.lang.String date) {
    }
    
    public final void selectTime(@org.jetbrains.annotations.NotNull()
    java.lang.String time) {
    }
    
    private final void updateAvailableTimes() {
    }
    
    public final void confirmBooking() {
    }
}