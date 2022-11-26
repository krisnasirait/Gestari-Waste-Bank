package com.eros.gestariwastebank.domain.validating

class ValidateNik {
    fun executer(nik: String): ValidationResult {
        if (nik.isBlank()) {
            return ValidationResult(
                false,
                "NIK tidak boleh kosong!"
            )
        }else if(nik.length > 12) {
            return ValidationResult(
                false,
                "NIK anda lebih dari 12 angka!"
            )
        }
        return ValidationResult(
            true
        )
    }
}