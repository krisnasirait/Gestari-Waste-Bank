package com.eros.gestariwastebank.domain.validate

class ValidatePhone {
    fun executer(phoneNumber: String): ValidationResult {
        if (phoneNumber.isBlank()) {
            return ValidationResult(
                false,
                "Nomor telp tidak boleh kosong!"
            )
        } else if (phoneNumber.length < 10) {
            return ValidationResult(
                false,
                "Nomor telp anda tidak valid!"
            )
        }
        return ValidationResult(
            true
        )
    }
}