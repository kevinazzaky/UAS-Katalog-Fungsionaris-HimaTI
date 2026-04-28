package com.example.kataloghimati.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kataloghimati.R
import com.example.kataloghimati.model.Fungsionaris

class FungsionarisAdapter(private var listFungsionaris: List<Fungsionaris>) :
    RecyclerView.Adapter<FungsionarisAdapter.FungsionarisViewHolder>() {


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
        val fungsionaris = listFungsionaris[position]

        holder.tvNama.text = fungsionaris.nama


        holder.tvNim.text = "NIM: ${fungsionaris.nim}"
        holder.tvJabatan.text = "Jabatan: ${fungsionaris.jabatan}"
    }

    override fun getItemCount(): Int {
        return listFungsionaris.size
    }

    fun updateData(newList: List<Fungsionaris>) {
        listFungsionaris = newList
        notifyDataSetChanged()
    }
}