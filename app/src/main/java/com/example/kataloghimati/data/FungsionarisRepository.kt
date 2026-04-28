package com.example.kataloghimati.data

import kotlinx.coroutines.flow.Flow

class FungsionarisRepository(private val fungsionarisDao: FungsionarisDao) {

    // Mengambil data yang sudah ter-SORTING
    val semuaFungsionaris: Flow<List<FungsionarisEntity>> = fungsionarisDao.ambilSemuaFungsionarisSorted()

    // Menjalankan fungsi SEARCHING
    fun cariData(query: String): Flow<List<FungsionarisEntity>> {
        return fungsionarisDao.cariFungsionaris("%$query%")
    }

    suspend fun tambahData(fungsionaris: FungsionarisEntity) {
        fungsionarisDao.tambahFungsionaris(fungsionaris)
    }
}
