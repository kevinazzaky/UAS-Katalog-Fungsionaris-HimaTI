package com.example.kataloghimati.presentation.login

import androidx.lifecycle.ViewModel
import com.example.kataloghimati.domain.usecase.LoginValidationUseCase

class LoginViewModel : ViewModel() {
    private val validationUseCase = LoginValidationUseCase()

    fun validateInput(name: String, nim: String): Pair<Boolean, String?> {
        if (!validationUseCase.isNameValid(name)) {
            return Pair(false, "Nama minimal harus 3 huruf!")
        }
        if (!validationUseCase.isNimValid(nim)) {
            return Pair(false, "NIM tidak valid atau terlalu pendek!")
        }
        return Pair(true, null)
    }
}