package com.example.kataloghimati.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kataloghimati.R
import com.example.kataloghimati.adapter.FungsionarisAdapter
import com.example.kataloghimati.data.AppDatabase
import com.example.kataloghimati.data.FungsionarisRepository
import com.example.kataloghimati.presentation.main.MainViewModel

class SearchFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: FungsionarisAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = AppDatabase.getDatabase(requireContext())
        val repository = FungsionarisRepository(database.fungsionarisDao())
        viewModel = MainViewModel(repository)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_search_results)
        adapter = FungsionarisAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        val etSearchBar = view.findViewById<EditText>(R.id.et_search_bar)

        etSearchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val kataKunci = s.toString()


                try {

                    Log.d("42430029", "User mengetik pencarian: '$kataKunci'")

                    if (kataKunci.isNotEmpty()) {
                        viewModel.cariDataBerdasarkanNama(kataKunci).observe(viewLifecycleOwner) { hasil ->
                            adapter.submitList(hasil)

                            Log.d("42430029", "Pencarian '$kataKunci' menemukan ${hasil.size} data.")
                        }
                    } else {
                        adapter.submitList(emptyList())
                    }
                } catch (e: Exception) {

                    Log.e("42430029", "ERROR saat mencari data: ${e.message}")
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}