package com.barbeariapremium.app.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceManager @Inject constructor(
    @ApplicationContext context: Context
) {
    private val prefs: SharedPreferences = context.getSharedPreferences("barber_premium_prefs", Context.MODE_PRIVATE)

    fun setSelectedUnitId(unitId: String) {
        prefs.edit().putString("selected_unit_id", unitId).apply()
    }

    fun getSelectedUnitId(): String? {
        return prefs.getString("selected_unit_id", null)
    }

    fun clearSelectedUnit() {
        prefs.edit().remove("selected_unit_id").apply()
    }
}
