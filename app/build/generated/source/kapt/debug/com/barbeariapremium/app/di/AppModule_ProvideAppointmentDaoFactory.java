package com.barbeariapremium.app.di;

import com.barbeariapremium.app.data.local.AppDatabase;
import com.barbeariapremium.app.data.local.dao.AppointmentDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class AppModule_ProvideAppointmentDaoFactory implements Factory<AppointmentDao> {
  private final Provider<AppDatabase> dbProvider;

  public AppModule_ProvideAppointmentDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public AppointmentDao get() {
    return provideAppointmentDao(dbProvider.get());
  }

  public static AppModule_ProvideAppointmentDaoFactory create(Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideAppointmentDaoFactory(dbProvider);
  }

  public static AppointmentDao provideAppointmentDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAppointmentDao(db));
  }
}
