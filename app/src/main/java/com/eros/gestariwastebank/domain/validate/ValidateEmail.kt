package com.eros.gestariwastebank.domain.validate

import android.util.Patterns

class ValidateEmail {
    fun executer(email: String): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(
                false,
                "Email tidak boleh kosong!"
            )
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                false,
                "Email anda tidak valid!"
            )
        }
        return ValidationResult(
            true
        )
    }
}