package com.eros.gestariwastebank.domain.validating

import android.util.Patterns

class ValidateEmail {
    fun executer(email: String): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(
                false,
                "The email can't be blank!"
            )
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                false,
                "That's not a valid email!"
            )
        }
        return ValidationResult(
            true
        )
    }
}