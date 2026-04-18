package com.barbeariapremium.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ<\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u001eH\u0086@\u00a2\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\"J\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0$H\u0086@\u00a2\u0006\u0002\u0010\u001fJ\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0$0&J$\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u001a0$2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010(J\u0012\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0$0&J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001a0$2\u0006\u0010!\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\"J\u001a\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0$0&2\u0006\u0010!\u001a\u00020\u0012J\u0016\u0010-\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@\u00a2\u0006\u0002\u0010\u001cJ$\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010/\u001a\u00020*H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b0\u00101J,\u00102\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b5\u0010(J,\u00106\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u00107\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b9\u0010:R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006;"}, d2 = {"Lcom/barbeariapremium/app/data/repository/AppointmentRepository;", "", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "appointmentDao", "Lcom/barbeariapremium/app/data/local/dao/AppointmentDao;", "preferenceManager", "Lcom/barbeariapremium/app/data/local/prefs/PreferenceManager;", "context", "Landroid/content/Context;", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lcom/barbeariapremium/app/data/local/dao/AppointmentDao;Lcom/barbeariapremium/app/data/local/prefs/PreferenceManager;Landroid/content/Context;)V", "appointmentsCollection", "Lcom/google/firebase/firestore/CollectionReference;", "promotionsCollection", "blockSchedule", "Lkotlin/Result;", "", "barberId", "", "barberName", "date", "time", "blockSchedule-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAppointment", "appointment", "Lcom/barbeariapremium/app/data/model/Appointment;", "createAppointment-gIAlu-s", "(Lcom/barbeariapremium/app/data/model/Appointment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAllAppointments", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAndCacheUserAppointments", "userId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAppointments", "", "getAllAppointmentsFlow", "Lkotlinx/coroutines/flow/Flow;", "getBarberAppointments", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPromotionsFlow", "Lcom/barbeariapremium/app/data/model/Promotion;", "getUserAppointments", "getUserAppointmentsFlow", "processLoyaltyForAppointment", "savePromotion", "promotion", "savePromotion-gIAlu-s", "(Lcom/barbeariapremium/app/data/model/Promotion;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAppointmentStatus", "appointmentId", "status", "updateAppointmentStatus-0E7RQCE", "updatePromotionStatus", "promotionId", "isActive", "updatePromotionStatus-0E7RQCE", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AppointmentRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore db = null;
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.local.dao.AppointmentDao appointmentDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.local.prefs.PreferenceManager preferenceManager = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.CollectionReference appointmentsCollection = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.CollectionReference promotionsCollection = null;
    
    @javax.inject.Inject()
    public AppointmentRepository(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore db, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.local.dao.AppointmentDao appointmentDao, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.local.prefs.PreferenceManager preferenceManager, @dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.barbeariapremium.app.data.model.Appointment>> getUserAppointmentsFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.barbeariapremium.app.data.model.Appointment>> getAllAppointmentsFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object fetchAllAppointments(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object fetchAndCacheUserAppointments(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserAppointments(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.barbeariapremium.app.data.model.Appointment>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getBarberAppointments(@org.jetbrains.annotations.NotNull()
    java.lang.String barberId, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.barbeariapremium.app.data.model.Appointment>> $completion) {
        return null;
    }
    
    private final java.lang.Object processLoyaltyForAppointment(com.barbeariapremium.app.data.model.Appointment appointment, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllAppointments(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.barbeariapremium.app.data.model.Appointment>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.barbeariapremium.app.data.model.Promotion>> getPromotionsFlow() {
        return null;
    }
}