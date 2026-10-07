package com.example.practica05.data

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {

    // Archivo interno donde se guardarán las preferencias
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(
            "UserPreferences",
            Context.MODE_PRIVATE
        )

    companion object {
        const val KEY_USERNAME = "key_username"
        const val KEY_NOTIFICATIONS = "key_notifications"
        const val KEY_DARK_THEME = "key_dark_theme"
    }

    // Guardar preferencias
    fun saveSettings(
        username: String,
        notifications: Boolean,
        darkTheme: Boolean
    ) {
        sharedPreferences.edit()
            .putString(KEY_USERNAME, username)
            .putBoolean(KEY_NOTIFICATIONS, notifications)
            .putBoolean(KEY_DARK_THEME, darkTheme)
            .apply()
    }

    // Recuperar nombre
    fun getUsername(): String {
        return sharedPreferences.getString(
            KEY_USERNAME,
            ""
        ) ?: ""
    }

    // Recuperar estado de notificaciones
    fun getNotifications(): Boolean {
        return sharedPreferences.getBoolean(
            KEY_NOTIFICATIONS,
            false
        )
    }

    // Recuperar tema oscuro
    fun getDarkTheme(): Boolean {
        return sharedPreferences.getBoolean(
            KEY_DARK_THEME,
            false
        )
    }

    // Borrar todas las preferencias
    fun clearPreferences() {
        sharedPreferences.edit()
            .clear()
            .apply()
    }
}