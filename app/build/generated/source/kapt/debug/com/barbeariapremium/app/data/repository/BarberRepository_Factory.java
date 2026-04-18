package com.barbeariapremium.app.data.repository;

import com.barbeariapremium.app.data.local.dao.BarberDao;
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
public final class BarberRepository_Factory implements Factory<BarberRepository> {
  private final Provider<FirebaseFirestore> dbProvider;

  private final Provider<BarberDao> barberDaoProvider;

  private final Provider<PreferenceManager> preferenceManagerProvider;

  public BarberRepository_Factory(Provider<FirebaseFirestore> dbProvider,
      Provider<BarberDao> barberDaoProvider,
      Provider<PreferenceManager> preferenceManagerProvider) {
    this.dbProvider = dbProvider;
    this.barberDaoProvider = barberDaoProvider;
    this.preferenceManagerProvider = preferenceManagerProvider;
  }

  @Override
  public BarberRepository get() {
    return newInstance(dbProvider.get(), barberDaoProvider.get(), preferenceManagerProvider.get());
  }

  public static BarberRepository_Factory create(Provider<FirebaseFirestore> dbProvider,
      Provider<BarberDao> barberDaoProvider,
      Provider<PreferenceManager> preferenceManagerProvider) {
    return new BarberRepository_Factory(dbProvider, barberDaoProvider, preferenceManagerProvider);
  }

  public static BarberRepository newInstance(FirebaseFirestore db, BarberDao barberDao,
      PreferenceManager preferenceManager) {
    return new BarberRepository(db, barberDao, preferenceManager);
  }
}
