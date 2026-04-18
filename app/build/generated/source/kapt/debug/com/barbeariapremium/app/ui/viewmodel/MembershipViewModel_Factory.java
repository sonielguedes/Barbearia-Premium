package com.barbeariapremium.app.ui.viewmodel;

import com.barbeariapremium.app.data.repository.AuthRepository;
import com.google.firebase.firestore.FirebaseFirestore;
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
public final class MembershipViewModel_Factory implements Factory<MembershipViewModel> {
  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<FirebaseFirestore> firestoreProvider;

  public MembershipViewModel_Factory(Provider<AuthRepository> authRepositoryProvider,
      Provider<FirebaseFirestore> firestoreProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
    this.firestoreProvider = firestoreProvider;
  }

  @Override
  public MembershipViewModel get() {
    return newInstance(authRepositoryProvider.get(), firestoreProvider.get());
  }

  public static MembershipViewModel_Factory create(Provider<AuthRepository> authRepositoryProvider,
      Provider<FirebaseFirestore> firestoreProvider) {
    return new MembershipViewModel_Factory(authRepositoryProvider, firestoreProvider);
  }

  public static MembershipViewModel newInstance(AuthRepository authRepository,
      FirebaseFirestore firestore) {
    return new MembershipViewModel(authRepository, firestore);
  }
}
