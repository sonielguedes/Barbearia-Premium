package com.barbeariapremium.app.data.local.dao

import androidx.room.*
import com.barbeariapremium.app.data.model.Coupon
import kotlinx.coroutines.flow.Flow

@Dao
interface CouponDao {
    @Query("SELECT * FROM coupons WHERE code = :code AND isActive = 1 LIMIT 1")
    suspend fun getValidCoupon(code: String): Coupon?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoupon(coupon: Coupon)

    @Query("SELECT * FROM coupons")
    fun getAllCoupons(): Flow<List<Coupon>>

    @Delete
    suspend fun deleteCoupon(coupon: Coupon)
}
