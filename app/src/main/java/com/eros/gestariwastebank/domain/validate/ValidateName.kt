package com.eros.gestariwastebank.domain.validate

class ValidateName {
    fun executer(name: String): ValidationResult {
        if (name.isBlank()) {
            return ValidationResult(
                false,
                "Nama tidak boleh kosong!"
            )
        }
        return ValidationResult(
            true
        )
    }
}