package com.example.kataloghimati.data

import kotlinx.coroutines.flow.Flow

class FungsionarisRepository(private val fungsionarisDao: FungsionarisDao) {


    val semuaFungsionaris: Flow<List<FungsionarisEntity>> = fungsionarisDao.ambilSemuaFungsionarisSorted()


    fun cariData(query: String): Flow<List<FungsionarisEntity>> {
        return fungsionarisDao.cariFungsionaris("%$query%")
    }

    suspend fun tambahData(fungsionaris: FungsionarisEntity) {
        fungsionarisDao.tambahFungsionaris(fungsionaris)
    }


    suspend fun injeksiDataAwalJikaKosong(listDataAwal: List<FungsionarisEntity>) {

        if (fungsionarisDao.cekJumlahData() == 0) {
            fungsionarisDao.tambahBanyakFungsionaris(listDataAwal)
        }
    }
}