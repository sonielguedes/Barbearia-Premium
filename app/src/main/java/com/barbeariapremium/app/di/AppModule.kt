package com.barbeariapremium.app.di

import android.content.Context
import androidx.room.Room
import com.barbeariapremium.app.data.local.AppDatabase
import com.barbeariapremium.app.data.local.dao.AppointmentDao
import com.barbeariapremium.app.data.local.dao.BarberDao
import com.barbeariapremium.app.data.local.dao.CouponDao
import com.barbeariapremium.app.data.local.dao.ServiceDao
import com.barbeariapremium.app.data.local.dao.UserDao
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "barber_pro_db"
        )
        .fallbackToDestructiveMigration()
        .build()
    }

    @Provides
    fun provideBarberDao(db: AppDatabase): BarberDao = db.barberDao()

    @Provides
    fun provideServiceDao(db: AppDatabase): ServiceDao = db.serviceDao()

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

    @Provides
    fun provideAppointmentDao(db: AppDatabase): AppointmentDao = db.appointmentDao()

    @Provides
    fun provideCouponDao(db: AppDatabase): CouponDao = db.couponDao()
}
