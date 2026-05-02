package com.example.kataloghimati.presentation.main

import android.util.Log
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
    private var isAscendingSort = true

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


        try {

            Log.d("42430029", "Membuka Tab: $kategori, Urutan A-Z: $isAscendingSort")


            val dataTersaring = dataAsli.filter { it.divisi.contains(kategori, ignoreCase = true) }

            val dataTerurut = terapkanBubbleSort(dataTersaring, isAscendingSort)

            _daftarTampil.value = dataTerurut

        } catch (e: Exception) {

            Log.e("42430029", "Terjadi Kesalahan: ${e.message}")
        }
    }

    fun ubahUrutan(isAscending: Boolean) {
        isAscendingSort = isAscending
        filterBerdasarkanKategori(kategoriAktif, posisiTabAktif)
    }

    private fun terapkanBubbleSort(list: List<FungsionarisEntity>, isAscending: Boolean): List<FungsionarisEntity> {
        val array = list.toTypedArray()
        val n = array.size

        for (i in 0 until n - 1) {
            for (j in 0 until n - i - 1) {
                val nama1 = array[j].nama.lowercase()
                val nama2 = array[j + 1].nama.lowercase()

                val harusDitukar = if (isAscending) {
                    nama1 > nama2
                } else {
                    nama1 < nama2
                }

                if (harusDitukar) {
                    val temp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = temp
                }
            }
        }
        return array.toList()
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

// Factory ViewModel
class MainViewModelFactory(private val repository: FungsionarisRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}