package com.barbeariapremium.app.ui.viewmodel;

import com.barbeariapremium.app.data.repository.AppointmentRepository;
import com.barbeariapremium.app.data.repository.AuthRepository;
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
public final class AuthViewModel_Factory implements Factory<AuthViewModel> {
  private final Provider<AuthRepository> repositoryProvider;

  private final Provider<AppointmentRepository> appointmentRepositoryProvider;

  public AuthViewModel_Factory(Provider<AuthRepository> repositoryProvider,
      Provider<AppointmentRepository> appointmentRepositoryProvider) {
    this.repositoryProvider = repositoryProvider;
    this.appointmentRepositoryProvider = appointmentRepositoryProvider;
  }

  @Override
  public AuthViewModel get() {
    return newInstance(repositoryProvider.get(), appointmentRepositoryProvider.get());
  }

  public static AuthViewModel_Factory create(Provider<AuthRepository> repositoryProvider,
      Provider<AppointmentRepository> appointmentRepositoryProvider) {
    return new AuthViewModel_Factory(repositoryProvider, appointmentRepositoryProvider);
  }

  public static AuthViewModel newInstance(AuthRepository repository,
      AppointmentRepository appointmentRepository) {
    return new AuthViewModel(repository, appointmentRepository);
  }
}
