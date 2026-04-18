package com.barbeariapremium.app.data.repository

import com.barbeariapremium.app.data.model.User
import com.barbeariapremium.app.data.local.dao.UserDao
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val auth: FirebaseAuth,
    private val db: FirebaseFirestore,
    private val userDao: UserDao
) {
    private val masterAdmins = listOf("sonieloficial@gmail.com", "admin@barberpro.com")

    private fun isMasterAdmin(email: String?): Boolean {
        if (email == null) return false
        return masterAdmins.any { it.equals(email, ignoreCase = true) }
    }

    suspend fun register(user: User, password: String): Result<Boolean> {
        return try {
            val result = auth.createUserWithEmailAndPassword(user.email, password).await()
            val uid = result.user?.uid ?: throw Exception("Failed to get UID")
            
            // Verifica se é um administrador mestre
            val userWithUid = user.copy(uid = uid, isAdmin = isMasterAdmin(user.email) || user.isAdmin)
            
            // Salva no Firestore
            db.collection("users").document(uid).set(userWithUid).await()
            
            // Salva no SQLite local
            userDao.insertUser(userWithUid)
            
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun login(email: String, password: String): Result<Boolean> {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            val uid = result.user?.uid
            
            if (uid != null) {
                // Busca dados atualizados e salva no SQLite
                getUserData(uid)?.let { user ->
                    // Força admin se estiver na lista de master admins
                    val finalUser = if (isMasterAdmin(user.email)) {
                        user.copy(isAdmin = true)
                    } else {
                        user
                    }
                    userDao.insertUser(finalUser)
                }
            }
            
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun logout() {
        auth.signOut()
        userDao.clearAllUsers()
    }

    suspend fun deleteUserAccount(): Result<Boolean> {
        return try {
            val user = auth.currentUser ?: throw Exception("Usuário não autenticado")
            val uid = user.uid

            // 1. Remover do Firestore
            db.collection("users").document(uid).delete().await()

            // 2. Remover do SQLite local
            userDao.clearAllUsers()

            // 3. Remover do Firebase Auth
            user.delete().await()

            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun getCurrentUser() = auth.currentUser

    fun getLocalUser() = userDao.getLoggedUser()

    suspend fun getUserData(uid: String): User? {
        // Tenta buscar local primeiro, se não encontrar busca no Firestore
        val localUser = userDao.getUserById(uid)
        if (localUser != null) return localUser

        return try {
            val snapshot = db.collection("users").document(uid).get().await()
            val user = snapshot.toObject(User::class.java)
            if (user != null) {
                userDao.insertUser(user)
            }
            user
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getAllUsers(): List<User> {
        return try {
            val snapshot = db.collection("users").get().await()
            snapshot.toObjects(User::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun updateMembershipStatus(uid: String, status: String): Result<Boolean> {
        return try {
            db.collection("users").document(uid).update("status", status).await()
            userDao.updateUserStatus(uid, status)
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
