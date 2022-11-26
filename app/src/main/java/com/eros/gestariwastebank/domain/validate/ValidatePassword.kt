package com.eros.gestariwastebank.domain.validate

class ValidatePassword {
    fun executer(password: String, confPassword: String): ValidationResult {
        if (password.isBlank()) {
            return ValidationResult(
                false,
                "Password tidak boleh kosong!"
            )
        } else if (password != confPassword) {
            return ValidationResult(
                false,
                "Password and konfirmasi tidak sama!"
            )
        } else if (confPassword.isBlank()) {
            return ValidationResult(
                false,
                "Konfirmasi password tidak boleh kosong!"
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
                "Password harus kombinasi angka dan huruf!"
            )
        }
        return ValidationResult(
            true
        )
    }
}