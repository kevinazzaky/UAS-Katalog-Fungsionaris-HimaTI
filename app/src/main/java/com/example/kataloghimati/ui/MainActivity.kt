package com.example.kataloghimati.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kataloghimati.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Menangkap data Nama yang dikirim dari Halaman Login (MILESTONE MINGGU 2)
        val namaPengguna = intent.getStringExtra("USER_NAME")
        if (namaPengguna != null) {
            Toast.makeText(this, "Selamat datang, $namaPengguna!", Toast.LENGTH_SHORT).show()
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // 2. Buka HomeFragment secara otomatis saat pertama kali masuk
        if (savedInstanceState == null) {
            bukaFragment(HomeFragment())
        }

        // 3. Logika saat tombol navigasi bawah diklik
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    bukaFragment(HomeFragment())
                    true
                }
                R.id.nav_search -> {
                    bukaFragment(SearchFragment())
                    true
                }
                else -> false
            }
        }
    }

    // Fungsi pintar untuk mengganti-ganti isi layar (Fragment)
    private fun bukaFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}