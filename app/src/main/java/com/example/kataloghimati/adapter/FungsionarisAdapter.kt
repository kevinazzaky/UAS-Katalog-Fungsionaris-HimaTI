package com.example.kataloghimati.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kataloghimati.R
import com.example.kataloghimati.data.FungsionarisEntity


class FungsionarisAdapter : ListAdapter<FungsionarisEntity, FungsionarisAdapter.FungsionarisViewHolder>(DiffCallback) {

    class FungsionarisViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNama: TextView = itemView.findViewById(R.id.tv_nama)
        val tvNim: TextView = itemView.findViewById(R.id.tv_nim)
        val tvJabatan: TextView = itemView.findViewById(R.id.tv_jabatan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FungsionarisViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fungsionaris, parent, false)
        return FungsionarisViewHolder(view)
    }

    override fun onBindViewHolder(holder: FungsionarisViewHolder, position: Int) {
        // 2. Mengambil data dari Room Database
        val fungsionaris = getItem(position)

        // 3. Menempelkan data ke layar
        holder.tvNama.text = fungsionaris.nama
        holder.tvNim.text = "NIM: ${fungsionaris.nim}"

        // Menggabungkan Divisi dan Tahun agar tampil di kolom Jabatan
        holder.tvJabatan.text = "Divisi ${fungsionaris.divisi} (${fungsionaris.tahun})"
    }

    // 4. Alat pintar untuk mengecek jika ada data baru masuk/berubah dari database
    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<FungsionarisEntity>() {
            override fun areItemsTheSame(oldItem: FungsionarisEntity, newItem: FungsionarisEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: FungsionarisEntity, newItem: FungsionarisEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}