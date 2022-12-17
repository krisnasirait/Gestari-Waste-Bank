package com.eros.gestariwastebank.data.helpers

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceHelper(context: Context) {
    private val PREFS_FILENAME = "badi.prefs"
    private val PREF_KEY_EMAIL = "email"
    private val PREF_KEY_PASSWORD = "password"
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)

    fun saveCredentials(email: String, password: String) {
        val editor = prefs.edit()
        editor.putString(PREF_KEY_EMAIL, email)
        editor.putString(PREF_KEY_PASSWORD, password)
        editor.apply()
    }

    fun getEmail(): String? {
        return prefs.getString(PREF_KEY_EMAIL, null)
    }

    fun getPassword(): String? {
        return prefs.getString(PREF_KEY_PASSWORD, null)
    }
}