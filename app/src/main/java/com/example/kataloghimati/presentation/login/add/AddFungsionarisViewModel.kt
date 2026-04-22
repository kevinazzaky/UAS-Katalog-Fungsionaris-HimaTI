package com.example.kataloghimati.presentation.login.add

import androidx.lifecycle.ViewModel
import com.example.kataloghimati.domain.usecase.AddFungsionarisUseCase

class AddFungsionarisViewModel : ViewModel() {

    // Panggil use case yang sudah kita buat
    private val validationUseCase = AddFungsionarisUseCase()

    fun cekDataBaru(nama: String, nim: String, tahun: String, divisi: String): Pair<Boolean, String> {
        // Lemparkan data dari UI ke UseCase untuk diperiksa
        return validationUseCase.validate(nama, nim, tahun, divisi)
    }
}