package com.eros.gestariwastebank.domain.validate

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)
