package com.barbeariapremium.app.ui.viewmodel;

import com.barbeariapremium.app.data.repository.AppointmentRepository;
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
public final class AiViewModel_Factory implements Factory<AiViewModel> {
  private final Provider<AppointmentRepository> appointmentRepositoryProvider;

  public AiViewModel_Factory(Provider<AppointmentRepository> appointmentRepositoryProvider) {
    this.appointmentRepositoryProvider = appointmentRepositoryProvider;
  }

  @Override
  public AiViewModel get() {
    return newInstance(appointmentRepositoryProvider.get());
  }

  public static AiViewModel_Factory create(
      Provider<AppointmentRepository> appointmentRepositoryProvider) {
    return new AiViewModel_Factory(appointmentRepositoryProvider);
  }

  public static AiViewModel newInstance(AppointmentRepository appointmentRepository) {
    return new AiViewModel(appointmentRepository);
  }
}
