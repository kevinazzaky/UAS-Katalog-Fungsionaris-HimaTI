package com.example.kataloghimati.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.kataloghimati.data.DataFungsionaris
import com.example.kataloghimati.data.FungsionarisEntity
import com.example.kataloghimati.data.FungsionarisRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: FungsionarisRepository) : ViewModel() {

    private var dataAsli: List<FungsionarisEntity> = emptyList()
    private var kategoriAktif = "Pembimbing"
    private var posisiTabAktif = 0

    private val _daftarTampil = MutableLiveData<List<FungsionarisEntity>>()
    val daftarTampil: LiveData<List<FungsionarisEntity>> = _daftarTampil

    init {
        masukkanDataBawaan()

        viewModelScope.launch {
            repository.semuaFungsionaris.collect { listData ->
                dataAsli = listData
                filterBerdasarkanKategori(kategoriAktif, posisiTabAktif)
            }
        }
    }


    fun filterBerdasarkanKategori(kategori: String, posisi: Int) {
        kategoriAktif = kategori
        posisiTabAktif = posisi
        val dataTersaring = dataAsli.filter { it.divisi.contains(kategori, ignoreCase = true) }
        _daftarTampil.value = dataTersaring
    }

    fun getPosisiTabAktif() = posisiTabAktif

    fun tambahData(entity: FungsionarisEntity) = viewModelScope.launch {
        repository.tambahData(entity)
    }

    fun cariDataBerdasarkanNama(query: String) = repository.cariData(query).asLiveData()

    private fun masukkanDataBawaan() {
        viewModelScope.launch {
            val dataLama = DataFungsionaris.generateDataFungsionaris()
            val dataBaru = dataLama.map { data ->
                FungsionarisEntity(
                    nama = data.nama,
                    nim = data.nim,
                    divisi = "${data.jabatan} - ${data.kategori}",
                    tahun = "2026"
                )
            }
            repository.injeksiDataAwalJikaKosong(dataBaru)
        }
    }
}

class MainViewModelFactory(private val repository: FungsionarisRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}