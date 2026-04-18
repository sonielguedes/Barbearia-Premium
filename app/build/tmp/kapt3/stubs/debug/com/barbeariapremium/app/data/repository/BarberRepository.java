package com.barbeariapremium.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001aH\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001a0\u001cJ$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001f"}, d2 = {"Lcom/barbeariapremium/app/data/repository/BarberRepository;", "", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "barberDao", "Lcom/barbeariapremium/app/data/local/dao/BarberDao;", "preferenceManager", "Lcom/barbeariapremium/app/data/local/prefs/PreferenceManager;", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lcom/barbeariapremium/app/data/local/dao/BarberDao;Lcom/barbeariapremium/app/data/local/prefs/PreferenceManager;)V", "TAG", "", "addBarber", "Lkotlin/Result;", "", "barber", "Lcom/barbeariapremium/app/data/model/Barber;", "addBarber-gIAlu-s", "(Lcom/barbeariapremium/app/data/model/Barber;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBarber", "barberId", "deleteBarber-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAndCacheBarbers", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBarbers", "", "getBarbersFlow", "Lkotlinx/coroutines/flow/Flow;", "updateBarber", "updateBarber-gIAlu-s", "app_debug"})
public final class BarberRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore db = null;
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.local.dao.BarberDao barberDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.local.prefs.PreferenceManager preferenceManager = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "BarberRepository";
    
    @javax.inject.Inject()
    public BarberRepository(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore db, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.local.dao.BarberDao barberDao, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.local.prefs.PreferenceManager preferenceManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.barbeariapremium.app.data.model.Barber>> getBarbersFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object fetchAndCacheBarbers(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getBarbers(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.barbeariapremium.app.data.model.Barber>> $completion) {
        return null;
    }
}