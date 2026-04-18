package com.barbeariapremium.app.ui.viewmodel;

import com.barbeariapremium.app.data.repository.AppointmentRepository;
import com.barbeariapremium.app.data.repository.AuthRepository;
import com.barbeariapremium.app.data.repository.BarberRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class AdminViewModel_Factory implements Factory<AdminViewModel> {
  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<AppointmentRepository> appointmentRepositoryProvider;

  private final Provider<BarberRepository> barberRepositoryProvider;

  public AdminViewModel_Factory(Provider<AuthRepository> authRepositoryProvider,
      Provider<AppointmentRepository> appointmentRepositoryProvider,
      Provider<BarberRepository> barberRepositoryProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
    this.appointmentRepositoryProvider = appointmentRepositoryProvider;
    this.barberRepositoryProvider = barberRepositoryProvider;
  }

  @Override
  public AdminViewModel get() {
    return newInstance(authRepositoryProvider.get(), appointmentRepositoryProvider.get(), barberRepositoryProvider.get());
  }

  public static AdminViewModel_Factory create(Provider<AuthRepository> authRepositoryProvider,
      Provider<AppointmentRepository> appointmentRepositoryProvider,
      Provider<BarberRepository> barberRepositoryProvider) {
    return new AdminViewModel_Factory(authRepositoryProvider, appointmentRepositoryProvider, barberRepositoryProvider);
  }

  public static AdminViewModel newInstance(AuthRepository authRepository,
      AppointmentRepository appointmentRepository, BarberRepository barberRepository) {
    return new AdminViewModel(authRepository, appointmentRepository, barberRepository);
  }
}
