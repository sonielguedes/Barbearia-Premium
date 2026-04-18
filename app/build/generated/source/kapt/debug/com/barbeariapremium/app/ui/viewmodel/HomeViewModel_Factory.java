package com.barbeariapremium.app.ui.viewmodel;

import com.barbeariapremium.app.data.repository.AppointmentRepository;
import com.barbeariapremium.app.data.repository.AuthRepository;
import com.barbeariapremium.app.data.repository.BarberRepository;
import com.barbeariapremium.app.data.repository.ServiceRepository;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<AppointmentRepository> appointmentRepositoryProvider;

  private final Provider<ServiceRepository> serviceRepositoryProvider;

  private final Provider<BarberRepository> barberRepositoryProvider;

  public HomeViewModel_Factory(Provider<AuthRepository> authRepositoryProvider,
      Provider<AppointmentRepository> appointmentRepositoryProvider,
      Provider<ServiceRepository> serviceRepositoryProvider,
      Provider<BarberRepository> barberRepositoryProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
    this.appointmentRepositoryProvider = appointmentRepositoryProvider;
    this.serviceRepositoryProvider = serviceRepositoryProvider;
    this.barberRepositoryProvider = barberRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(authRepositoryProvider.get(), appointmentRepositoryProvider.get(), serviceRepositoryProvider.get(), barberRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<AuthRepository> authRepositoryProvider,
      Provider<AppointmentRepository> appointmentRepositoryProvider,
      Provider<ServiceRepository> serviceRepositoryProvider,
      Provider<BarberRepository> barberRepositoryProvider) {
    return new HomeViewModel_Factory(authRepositoryProvider, appointmentRepositoryProvider, serviceRepositoryProvider, barberRepositoryProvider);
  }

  public static HomeViewModel newInstance(AuthRepository authRepository,
      AppointmentRepository appointmentRepository, ServiceRepository serviceRepository,
      BarberRepository barberRepository) {
    return new HomeViewModel(authRepository, appointmentRepository, serviceRepository, barberRepository);
  }
}
