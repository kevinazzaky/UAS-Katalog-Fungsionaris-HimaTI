package com.example.kataloghimati.domain.usecase

class AddFungsionarisUseCase {

    // Mengembalikan Pair: Boolean (apakah sukses?) dan String (pesan error/suksesnya)
    fun validate(nama: String, nim: String, tahunAngkatan: String, divisi: String): Pair<Boolean, String> {

        // 1. Validasi Nama
        if (nama.trim().isEmpty()) {
            return Pair(false, "Nama fungsionaris tidak boleh kosong!")
        }

        // 2. Validasi NIM
        if (nim.trim().isEmpty()) {
            return Pair(false, "NIM tidak boleh kosong!")
        }
        if (nim.length < 8) {
            return Pair(false, "NIM tidak valid (minimal 8 angka)!")
        }

        // 3. Validasi Tahun Angkatan
        val tahun = tahunAngkatan.toIntOrNull()
        if (tahun == null) {
            return Pair(false, "Tahun angkatan harus berupa angka!")
        }
        if (tahun !in 2020..2026) {
            return Pair(false, "Tahun angkatan harus antara 2020 - 2026!")
        }

        // 4. Validasi Divisi
        if (divisi.trim().isEmpty() || divisi == "Pilih Divisi") {
            return Pair(false, "Silakan pilih divisi (Inti, PSDM, dll)!")
        }

        // Jika semua lolos rintangan di atas:
        return Pair(true, "Validasi Sukses! Data siap disimpan.")
    }
}