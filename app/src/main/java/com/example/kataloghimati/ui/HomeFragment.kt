package com.example.kataloghimati.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kataloghimati.R
import com.example.kataloghimati.adapter.FungsionarisAdapter
import com.example.kataloghimati.data.AppDatabase
import com.example.kataloghimati.data.FungsionarisRepository
import com.example.kataloghimati.presentation.main.MainViewModel
import com.example.kataloghimati.presentation.main.MainViewModelFactory
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment() {


    private val viewModel: MainViewModel by activityViewModels {
        val database = AppDatabase.getDatabase(requireContext())
        val repository = FungsionarisRepository(database.fungsionarisDao())
        MainViewModelFactory(repository)
    }

    private lateinit var adapter: FungsionarisAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_fungsionaris_home)
        adapter = FungsionarisAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter


        viewModel.daftarTampil.observe(viewLifecycleOwner) { listData ->
            adapter.submitList(listData)
        }


        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)


        val posisiTerakhir = viewModel.getPosisiTabAktif()
        tabLayout.getTabAt(posisiTerakhir)?.select()


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> viewModel.filterBerdasarkanKategori("Pembimbing", 0)
                    1 -> viewModel.filterBerdasarkanKategori("Inti", 1)
                    2 -> viewModel.filterBerdasarkanKategori("PSDM", 2)
                    3 -> viewModel.filterBerdasarkanKategori("HH", 3)
                    4 -> viewModel.filterBerdasarkanKategori("Kominfo", 4)
                    5 -> viewModel.filterBerdasarkanKategori("Delegasi", 5)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}