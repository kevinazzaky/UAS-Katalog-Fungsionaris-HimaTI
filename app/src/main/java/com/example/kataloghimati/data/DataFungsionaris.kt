package com.example.kataloghimati.data

import com.example.kataloghimati.model.Fungsionaris

object DataFungsionaris {
    fun generateDataFungsionaris(): List<Fungsionaris> {
        val daftarFungsionaris = ArrayList<Fungsionaris>()

        // ================= KATEGORI PEMBIMBING =================
        daftarFungsionaris.add(Fungsionaris("1", "Ir. Made Ari Riska Dayanti S.T., M.T.", "02.03.25.403", "Pembina", "Pembimbing"))

        // ================= KATEGORI INTI =================
        daftarFungsionaris.add(Fungsionaris("2", "Renald Kevin Azzaky", "4.24.3.0029", "Ketua Umum", "Inti"))
        daftarFungsionaris.add(Fungsionaris("3", "Kadek Wahyu Santika Putra", "4.24.3.0012", "Wakil Ketua", "Inti"))
        daftarFungsionaris.add(Fungsionaris("4", "I Made Dedy Wanditya", "4.24.3.0042", "Sekretaris Umum", "Inti"))
        daftarFungsionaris.add(Fungsionaris("5", "Gusti Ayu Emilia Artika", "4.25.3.0023", "Sekretaris I", "Inti"))
        daftarFungsionaris.add(Fungsionaris("6", "Komang Bayu Trias Gautama", "4.25.3.0019", "Sekretaris II", "Inti"))
        daftarFungsionaris.add(Fungsionaris("7", "Catherine Soenarjo", "4.25.3.0026", "Bendahara I", "Inti"))
        daftarFungsionaris.add(Fungsionaris("8", "Made Adelia Febriana", "4.25.3.0007", "Bendahara II", "Inti"))

        // ================= KATEGORI DELEGASI =================
        daftarFungsionaris.add(Fungsionaris("9", "Komang Indra Wirawan", "4.25.3.0039", "Delegasi", "Delegasi"))
        daftarFungsionaris.add(Fungsionaris("10", "Sad Bagus Ketut Ak", "4.25.3.0047", "Delegasi", "Delegasi"))

        // ================= KATEGORI HH =================
        daftarFungsionaris.add(Fungsionaris("11", "Yunima Dioranda Manik", "4.24.3.0030", "Koordinator Divisi HH", "HH"))
        daftarFungsionaris.add(Fungsionaris("12", "Indriani Asten", "4.24.3.0010", "Anggota Divisi HH", "HH"))
        daftarFungsionaris.add(Fungsionaris("13", "A.A Ngurah Agung Mahendra Sedana", "4.25.3.0043", "Anggota Divisi HH", "HH"))
        daftarFungsionaris.add(Fungsionaris("14", "I Komang Dika Gus Septa", "4.25.3.0015", "Anggota Divisi HH", "HH"))
        daftarFungsionaris.add(Fungsionaris("15", "Gede Bagus Indra Tanaya", "4.25.3.0034", "Anggota Divisi HH", "HH"))

        // ================= KATEGORI PSDM =================
        daftarFungsionaris.add(Fungsionaris("16", "Benedito Nidio Da Rosa Maia Tilman", "4.24.3.0032", "Koordinator Divisi PSDM", "PSDM"))
        daftarFungsionaris.add(Fungsionaris("17", "Ida Bagus Sugiharta Dharma Putra", "4.25.3.0028", "Anggota Divisi PSDM", "PSDM"))
        daftarFungsionaris.add(Fungsionaris("18", "Gusti ngurah Ardana Wijaya", "4.25.3.0029", "Anggota Divisi PSDM", "PSDM"))
        daftarFungsionaris.add(Fungsionaris("19", "Zintia Adella", "4.25.3.0036", "Anggota Divisi PSDM", "PSDM"))
        daftarFungsionaris.add(Fungsionaris("20", "Adelia Surya Putri", "4.25.3.0038", "Anggota Divisi PSDM", "PSDM"))
        daftarFungsionaris.add(Fungsionaris("21", "I Made Dandi Prayata Ardana", "4.25.3.0009", "Anggota Divisi PSDM", "PSDM"))

        // ================= KATEGORI KOMINFO =================
        daftarFungsionaris.add(Fungsionaris("22", "Cevyn Eduard Imanuel Dapa Talu", "4.24.3.0055", "Koordinator Divisi Kominfo", "Kominfo"))
        daftarFungsionaris.add(Fungsionaris("23", "Gabriel Jehuda Tamedo", "4.24.3.0007", "Anggota Divisi Kominfo", "Kominfo"))
        daftarFungsionaris.add(Fungsionaris("24", "Mochammad Akmal Anfal", "4.24.3.0041", "Anggota Divisi Kominfo", "Kominfo"))
        daftarFungsionaris.add(Fungsionaris("25", "Evan Safi Maulana Malik Ibrahim", "4.24.3.0019", "Anggota Divisi Kominfo", "Kominfo"))
        daftarFungsionaris.add(Fungsionaris("26", "I Wayan Yoga Karang", "4.24.3.0013", "Anggota Divisi Kominfo", "Kominfo"))
        daftarFungsionaris.add(Fungsionaris("27", "Ardelia Naenda Ahmadi", "4.25.3.0022", "Anggota Divisi Kominfo", "Kominfo"))
        daftarFungsionaris.add(Fungsionaris("28", "Friendly Riantha Dwi Pratama", "4.25.3.0033", "Anggota Divisi Kominfo", "Kominfo"))

        return daftarFungsionaris
    }
}