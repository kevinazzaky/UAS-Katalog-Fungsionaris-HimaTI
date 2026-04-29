package com.example.kataloghimati.presentation.login.add

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.kataloghimati.R
import com.example.kataloghimati.data.AppDatabase
import com.example.kataloghimati.data.FungsionarisEntity
import com.example.kataloghimati.data.FungsionarisRepository
import kotlinx.coroutines.launch

class AddFungsionarisActivity : AppCompatActivity() {

    private val viewModel = AddFungsionarisViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_fungsionaris)

        val etNama = findViewById<EditText>(R.id.et_add_nama)
        val etNim = findViewById<EditText>(R.id.et_add_nim)
        val etTahun = findViewById<EditText>(R.id.et_add_tahun)
        val spinnerDivisi = findViewById<AutoCompleteTextView>(R.id.spinner_add_divisi)
        val btnSimpan = findViewById<Button>(R.id.btn_simpan_data)


        val daftarDivisi = arrayOf("Inti", "PSDM", "Kominfo", "HH", "Delegasi", "Pembimbing")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, daftarDivisi)
        spinnerDivisi.setAdapter(adapter)

        btnSimpan.setOnClickListener {
            val nama = etNama.text.toString()
            val nim = etNim.text.toString()
            val tahun = etTahun.text.toString()
            val divisi = spinnerDivisi.text.toString()

            val hasilValidasi = viewModel.cekDataBaru(nama, nim, tahun, divisi)

            if (hasilValidasi.first) {

                val database = AppDatabase.getDatabase(this)
                val repository = FungsionarisRepository(database.fungsionarisDao())

                val fungsionarisBaru = FungsionarisEntity(
                    nama = nama,
                    nim = nim,
                    divisi = "Anggota Baru - $divisi",
                    tahun = tahun
                )

                lifecycleScope.launch {
                    repository.tambahData(fungsionarisBaru)

                    Toast.makeText(this@AddFungsionarisActivity, "Berhasil! Data $nama TERSIMPAN PERMANEN!", Toast.LENGTH_LONG).show()
                    finish()
                }

            } else {
                Toast.makeText(this, "Gagal: ${hasilValidasi.second}", Toast.LENGTH_LONG).show()
            }
        }
    }
}