package com.barbeariapremium.app.data.repository

import android.util.Log
import com.barbeariapremium.app.data.local.dao.ServiceDao
import com.barbeariapremium.app.data.local.prefs.PreferenceManager
import com.barbeariapremium.app.data.model.Service
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ServiceRepository @Inject constructor(
    private val db: FirebaseFirestore,
    private val serviceDao: ServiceDao,
    private val preferenceManager: PreferenceManager
) {
    private val TAG = "ServiceRepository"

    fun getServicesFlow(): Flow<List<Service>> = serviceDao.getAllServices()

    suspend fun fetchAndCacheServices() {
        try {
            val unitId = preferenceManager.getSelectedUnitId() ?: "1"
            Log.d(TAG, "Fetching services from Firestore for unit: $unitId")
            val snapshot = db.collection("services")
                .whereEqualTo("unitId", unitId)
                .get().await()
            Log.d(TAG, "Successfully fetched ${snapshot.size()} services")
            val services = snapshot.toObjects(Service::class.java)
            serviceDao.deleteAllServices()
            serviceDao.insertServices(services)
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching and caching services", e)
        }
    }

    suspend fun getServices(): List<Service> {
        return try {
            val unitId = preferenceManager.getSelectedUnitId() ?: "1"
            val snapshot = db.collection("services")
                .whereEqualTo("unitId", unitId)
                .get().await()
            val services = snapshot.toObjects(Service::class.java)
            serviceDao.deleteAllServices()
            serviceDao.insertServices(services)
            services
        } catch (e: Exception) {
            Log.e(TAG, "Error getting services, falling back to local storage", e)
            serviceDao.getAllServicesList()
        }
    }

    suspend fun addService(service: Service): Result<Boolean> {
        return try {
            Log.d(TAG, "Adding service to Firestore: ${service.name}")
            val docRef = db.collection("services").document()
            val unitId = preferenceManager.getSelectedUnitId() ?: "1"
            val serviceWithId = service.copy(id = docRef.id, unitId = unitId)
            docRef.set(serviceWithId).await()
            Log.d(TAG, "Successfully added service: ${service.name}")
            Result.success(true)
        } catch (e: Exception) {
            Log.e(TAG, "Error adding service: ${service.name}", e)
            Result.failure(e)
        }
    }
}
