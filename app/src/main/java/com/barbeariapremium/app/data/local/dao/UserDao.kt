package com.barbeariapremium.app.data.local.dao

import androidx.room.*
import com.barbeariapremium.app.data.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE uid = :uid")
    suspend fun getUserById(uid: String): User?

    @Query("SELECT * FROM users LIMIT 1")
    fun getLoggedUser(): Flow<User?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("DELETE FROM users")
    suspend fun clearAllUsers()

    @Query("UPDATE users SET status = :newStatus WHERE uid = :uid")
    suspend fun updateUserStatus(uid: String, newStatus: String)
}
