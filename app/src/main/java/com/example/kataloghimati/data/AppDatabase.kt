package com.example.kataloghimati.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FungsionarisEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    // Mendaftarkan Resepsionis (DAO) ke dalam gedung ini
    abstract fun fungsionarisDao(): FungsionarisDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Fungsi ini memastikan aplikasimu hanya membuat SATU gedung database
        // agar memori HP tidak bocor.
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "fungsionaris_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}