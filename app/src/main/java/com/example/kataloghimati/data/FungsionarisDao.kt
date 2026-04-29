package com.example.kataloghimati.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FungsionarisDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun tambahFungsionaris(fungsionaris: FungsionarisEntity)

    @Query("SELECT * FROM tabel_fungsionaris ORDER BY nama ASC")
    fun ambilSemuaFungsionarisSorted(): Flow<List<FungsionarisEntity>>


    @Query("SELECT * FROM tabel_fungsionaris WHERE nama LIKE :searchQuery")
    fun cariFungsionaris(searchQuery: String): Flow<List<FungsionarisEntity>>


    @Query("SELECT COUNT(id) FROM tabel_fungsionaris")
    suspend fun cekJumlahData(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun tambahBanyakFungsionaris(listFungsionaris: List<FungsionarisEntity>)
}