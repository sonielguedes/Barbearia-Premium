package com.barbeariapremium.app.data.repository;

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
public final class ReviewRepository_Factory implements Factory<ReviewRepository> {
  private final Provider<FirebaseFirestore> dbProvider;

  public ReviewRepository_Factory(Provider<FirebaseFirestore> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public ReviewRepository get() {
    return newInstance(dbProvider.get());
  }

  public static ReviewRepository_Factory create(Provider<FirebaseFirestore> dbProvider) {
    return new ReviewRepository_Factory(dbProvider);
  }

  public static ReviewRepository newInstance(FirebaseFirestore db) {
    return new ReviewRepository(db);
  }
}
