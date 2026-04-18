package com.barbeariapremium.app.di;

import com.barbeariapremium.app.data.local.AppDatabase;
import com.barbeariapremium.app.data.local.dao.ServiceDao;
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
public final class AppModule_ProvideServiceDaoFactory implements Factory<ServiceDao> {
  private final Provider<AppDatabase> dbProvider;

  public AppModule_ProvideServiceDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public ServiceDao get() {
    return provideServiceDao(dbProvider.get());
  }

  public static AppModule_ProvideServiceDaoFactory create(Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideServiceDaoFactory(dbProvider);
  }

  public static ServiceDao provideServiceDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideServiceDao(db));
  }
}
