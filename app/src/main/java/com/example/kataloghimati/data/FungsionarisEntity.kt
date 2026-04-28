package com.example.kataloghimati.data // Sesuaikan package-mu!

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabel_fungsionaris")
data class FungsionarisEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama: String,
    val nim: String,
    val tahun: String,
    val divisi: String
)