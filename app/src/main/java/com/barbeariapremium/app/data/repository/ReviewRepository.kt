package com.barbeariapremium.app.data.repository

import com.barbeariapremium.app.data.model.Review
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReviewRepository @Inject constructor(
    private val db: FirebaseFirestore
) {
    suspend fun addReview(review: Review): Result<Boolean> {
        return try {
            val docRef = db.collection("reviews").document()
            val reviewWithId = review.copy(id = docRef.id)
            docRef.set(reviewWithId).await()
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getBarberReviews(barberId: String): List<Review> {
        return try {
            val snapshot = db.collection("reviews")
                .whereEqualTo("barberId", barberId)
                .get().await()
            snapshot.toObjects(Review::class.java)
        } catch (e: Exception) {
            kotlin.collections.emptyList()
        }
    }
}
