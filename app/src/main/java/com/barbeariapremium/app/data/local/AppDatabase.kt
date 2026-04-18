package com.barbeariapremium.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.barbeariapremium.app.data.local.dao.*
import com.barbeariapremium.app.data.model.*

@Database(
    entities = [User::class, Barber::class, Service::class, Appointment::class, Coupon::class],
    version = 4,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun barberDao(): BarberDao
    abstract fun serviceDao(): ServiceDao
    abstract fun userDao(): UserDao
    abstract fun appointmentDao(): AppointmentDao
    abstract fun couponDao(): CouponDao
}
