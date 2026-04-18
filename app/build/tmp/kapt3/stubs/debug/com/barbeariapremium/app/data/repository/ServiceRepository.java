package com.barbeariapremium.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016H\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00160\u0018R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0019"}, d2 = {"Lcom/barbeariapremium/app/data/repository/ServiceRepository;", "", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "serviceDao", "Lcom/barbeariapremium/app/data/local/dao/ServiceDao;", "preferenceManager", "Lcom/barbeariapremium/app/data/local/prefs/PreferenceManager;", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lcom/barbeariapremium/app/data/local/dao/ServiceDao;Lcom/barbeariapremium/app/data/local/prefs/PreferenceManager;)V", "TAG", "", "addService", "Lkotlin/Result;", "", "service", "Lcom/barbeariapremium/app/data/model/Service;", "addService-gIAlu-s", "(Lcom/barbeariapremium/app/data/model/Service;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAndCacheServices", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServices", "", "getServicesFlow", "Lkotlinx/coroutines/flow/Flow;", "app_debug"})
public final class ServiceRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore db = null;
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.local.dao.ServiceDao serviceDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.barbeariapremium.app.data.local.prefs.PreferenceManager preferenceManager = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "ServiceRepository";
    
    @javax.inject.Inject()
    public ServiceRepository(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore db, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.local.dao.ServiceDao serviceDao, @org.jetbrains.annotations.NotNull()
    com.barbeariapremium.app.data.local.prefs.PreferenceManager preferenceManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.barbeariapremium.app.data.model.Service>> getServicesFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object fetchAndCacheServices(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getServices(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.barbeariapremium.app.data.model.Service>> $completion) {
        return null;
    }
}