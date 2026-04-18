package com.barbeariapremium.app.ui.viewmodel;

import com.barbeariapremium.app.data.local.dao.CouponDao;
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
public final class BookingViewModel_Factory implements Factory<BookingViewModel> {
  private final Provider<AppointmentRepository> appointmentRepositoryProvider;

  private final Provider<ServiceRepository> serviceRepositoryProvider;

  private final Provider<BarberRepository> barberRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<CouponDao> couponDaoProvider;

  public BookingViewModel_Factory(Provider<AppointmentRepository> appointmentRepositoryProvider,
      Provider<ServiceRepository> serviceRepositoryProvider,
      Provider<BarberRepository> barberRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider, Provider<CouponDao> couponDaoProvider) {
    this.appointmentRepositoryProvider = appointmentRepositoryProvider;
    this.serviceRepositoryProvider = serviceRepositoryProvider;
    this.barberRepositoryProvider = barberRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
    this.couponDaoProvider = couponDaoProvider;
  }

  @Override
  public BookingViewModel get() {
    return newInstance(appointmentRepositoryProvider.get(), serviceRepositoryProvider.get(), barberRepositoryProvider.get(), authRepositoryProvider.get(), couponDaoProvider.get());
  }

  public static BookingViewModel_Factory create(
      Provider<AppointmentRepository> appointmentRepositoryProvider,
      Provider<ServiceRepository> serviceRepositoryProvider,
      Provider<BarberRepository> barberRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider, Provider<CouponDao> couponDaoProvider) {
    return new BookingViewModel_Factory(appointmentRepositoryProvider, serviceRepositoryProvider, barberRepositoryProvider, authRepositoryProvider, couponDaoProvider);
  }

  public static BookingViewModel newInstance(AppointmentRepository appointmentRepository,
      ServiceRepository serviceRepository, BarberRepository barberRepository,
      AuthRepository authRepository, CouponDao couponDao) {
    return new BookingViewModel(appointmentRepository, serviceRepository, barberRepository, authRepository, couponDao);
  }
}
