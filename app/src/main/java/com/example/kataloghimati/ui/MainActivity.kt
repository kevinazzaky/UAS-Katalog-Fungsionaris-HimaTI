package com.example.kataloghimati.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kataloghimati.R
import com.example.kataloghimati.presentation.login.add.AddFungsionarisActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menangkap data Nama
        val namaPengguna = intent.getStringExtra("USER_NAME")
        if (namaPengguna != null) {
            Toast.makeText(this, "Selamat datang, $namaPengguna!", Toast.LENGTH_SHORT).show()
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val fabAdd = findViewById<FloatingActionButton>(R.id.fab_add_fungsionaris) // Kenalkan FAB


        fabAdd.setOnClickListener {
            val intent = Intent(this, AddFungsionarisActivity::class.java)
            startActivity(intent)
        }

        if (savedInstanceState == null) {
            bukaFragment(HomeFragment())
        }


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

    private fun bukaFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}