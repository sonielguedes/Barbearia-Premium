package com.barbeariapremium.app.data.repository;

import com.barbeariapremium.app.data.local.dao.ServiceDao;
import com.barbeariapremium.app.data.local.prefs.PreferenceManager;
import com.google.firebase.firestore.FirebaseFirestore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class ServiceRepository_Factory implements Factory<ServiceRepository> {
  private final Provider<FirebaseFirestore> dbProvider;

  private final Provider<ServiceDao> serviceDaoProvider;

  private final Provider<PreferenceManager> preferenceManagerProvider;

  public ServiceRepository_Factory(Provider<FirebaseFirestore> dbProvider,
      Provider<ServiceDao> serviceDaoProvider,
      Provider<PreferenceManager> preferenceManagerProvider) {
    this.dbProvider = dbProvider;
    this.serviceDaoProvider = serviceDaoProvider;
    this.preferenceManagerProvider = preferenceManagerProvider;
  }

  @Override
  public ServiceRepository get() {
    return newInstance(dbProvider.get(), serviceDaoProvider.get(), preferenceManagerProvider.get());
  }

  public static ServiceRepository_Factory create(Provider<FirebaseFirestore> dbProvider,
      Provider<ServiceDao> serviceDaoProvider,
      Provider<PreferenceManager> preferenceManagerProvider) {
    return new ServiceRepository_Factory(dbProvider, serviceDaoProvider, preferenceManagerProvider);
  }

  public static ServiceRepository newInstance(FirebaseFirestore db, ServiceDao serviceDao,
      PreferenceManager preferenceManager) {
    return new ServiceRepository(db, serviceDao, preferenceManager);
  }
}
