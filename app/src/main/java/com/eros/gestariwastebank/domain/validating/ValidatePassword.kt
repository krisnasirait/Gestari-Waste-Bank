package com.eros.gestariwastebank.domain.validating

import android.util.Patterns

class ValidatePassword {
    fun executer(password: String, confPassword: String): ValidationResult {
        if (password.isBlank()) {
            return ValidationResult(
                false,
                "The password can't be blank!"
            )
        } else if (password != confPassword) {
            return ValidationResult(
                false,
                "Password and confirmation is not same!"
            )
        } else if (confPassword.isBlank()) {
            return ValidationResult(
                false,
                "Password confirmation can't be blank!"
            )
        }
        val containsLetterAndDigits = password.any {
            it.isDigit()
        } && password.any {
            it.isLetter()
        }
        if (containsLetterAndDigits) {
            return ValidationResult(
                false,
                "Password need to contain letter and digit!"
            )
        }
        return ValidationResult(
            true
        )
    }
}