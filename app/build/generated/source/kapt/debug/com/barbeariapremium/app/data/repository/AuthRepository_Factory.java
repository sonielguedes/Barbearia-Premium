package com.barbeariapremium.app.data.repository;

import com.barbeariapremium.app.data.local.dao.UserDao;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AuthRepository_Factory implements Factory<AuthRepository> {
  private final Provider<FirebaseAuth> authProvider;

  private final Provider<FirebaseFirestore> dbProvider;

  private final Provider<UserDao> userDaoProvider;

  public AuthRepository_Factory(Provider<FirebaseAuth> authProvider,
      Provider<FirebaseFirestore> dbProvider, Provider<UserDao> userDaoProvider) {
    this.authProvider = authProvider;
    this.dbProvider = dbProvider;
    this.userDaoProvider = userDaoProvider;
  }

  @Override
  public AuthRepository get() {
    return newInstance(authProvider.get(), dbProvider.get(), userDaoProvider.get());
  }

  public static AuthRepository_Factory create(Provider<FirebaseAuth> authProvider,
      Provider<FirebaseFirestore> dbProvider, Provider<UserDao> userDaoProvider) {
    return new AuthRepository_Factory(authProvider, dbProvider, userDaoProvider);
  }

  public static AuthRepository newInstance(FirebaseAuth auth, FirebaseFirestore db,
      UserDao userDao) {
    return new AuthRepository(auth, db, userDao);
  }
}
