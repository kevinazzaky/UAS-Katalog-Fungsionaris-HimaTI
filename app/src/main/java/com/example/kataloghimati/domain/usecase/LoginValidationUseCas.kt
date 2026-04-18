package com.example.kataloghimati.domain.usecase

class LoginValidationUseCase {
    fun isNameValid(name: String): Boolean {
        return name.isNotBlank() && name.length >= 3
    }

    fun isNimValid(nim: String): Boolean {

        return nim.isNotBlank() && nim.length >= 8
    }
}