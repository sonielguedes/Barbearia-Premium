package com.barbeariapremium.app.data.repository;

import android.content.Context;
import com.barbeariapremium.app.data.local.dao.AppointmentDao;
import com.barbeariapremium.app.data.local.prefs.PreferenceManager;
import com.google.firebase.firestore.FirebaseFirestore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppointmentRepository_Factory implements Factory<AppointmentRepository> {
  private final Provider<FirebaseFirestore> dbProvider;

  private final Provider<AppointmentDao> appointmentDaoProvider;

  private final Provider<PreferenceManager> preferenceManagerProvider;

  private final Provider<Context> contextProvider;

  public AppointmentRepository_Factory(Provider<FirebaseFirestore> dbProvider,
      Provider<AppointmentDao> appointmentDaoProvider,
      Provider<PreferenceManager> preferenceManagerProvider, Provider<Context> contextProvider) {
    this.dbProvider = dbProvider;
    this.appointmentDaoProvider = appointmentDaoProvider;
    this.preferenceManagerProvider = preferenceManagerProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public AppointmentRepository get() {
    return newInstance(dbProvider.get(), appointmentDaoProvider.get(), preferenceManagerProvider.get(), contextProvider.get());
  }

  public static AppointmentRepository_Factory create(Provider<FirebaseFirestore> dbProvider,
      Provider<AppointmentDao> appointmentDaoProvider,
      Provider<PreferenceManager> preferenceManagerProvider, Provider<Context> contextProvider) {
    return new AppointmentRepository_Factory(dbProvider, appointmentDaoProvider, preferenceManagerProvider, contextProvider);
  }

  public static AppointmentRepository newInstance(FirebaseFirestore db,
      AppointmentDao appointmentDao, PreferenceManager preferenceManager, Context context) {
    return new AppointmentRepository(db, appointmentDao, preferenceManager, context);
  }
}
