package com.barbeariapremium.app.di;

import com.barbeariapremium.app.data.local.AppDatabase;
import com.barbeariapremium.app.data.local.dao.BarberDao;
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
public final class AppModule_ProvideBarberDaoFactory implements Factory<BarberDao> {
  private final Provider<AppDatabase> dbProvider;

  public AppModule_ProvideBarberDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public BarberDao get() {
    return provideBarberDao(dbProvider.get());
  }

  public static AppModule_ProvideBarberDaoFactory create(Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideBarberDaoFactory(dbProvider);
  }

  public static BarberDao provideBarberDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideBarberDao(db));
  }
}
