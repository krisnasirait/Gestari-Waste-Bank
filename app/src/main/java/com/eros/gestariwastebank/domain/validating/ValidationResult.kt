package com.eros.gestariwastebank.domain.validating

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)
