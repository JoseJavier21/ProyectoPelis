package com.example.proyectopelis.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectopelis.R
import com.example.proyectopelis.ViewModel
import com.example.proyectopelis.data.adapter.AdapterUpComing
import com.example.proyectopelis.databinding.FragmentUpComingBinding

class UpComing : Fragment() {

    private lateinit var binding: FragmentUpComingBinding
    private lateinit var adapter: AdapterUpComing
    private val myViewModel: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpComingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_main, menu)

                val menulupa = menu.findItem(R.id.app_bar_search)
                val lupa = menulupa.actionView as SearchView
                lupa.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        adapter.getFilter()
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        adapter.getFilter()
                        return true
                    }

                })
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        }, viewLifecycleOwner, androidx.lifecycle.Lifecycle.State.RESUMED)


        var actual = 1

        myViewModel.Rated.observe(viewLifecycleOwner){
            val paginas = it?.totalPages


            when(actual){
                1 -> {
                    binding.buAtras.visibility = View.GONE
                    binding.buprox.visibility = View.VISIBLE
                }
                2 -> {
                    binding.buAtras.visibility = View.VISIBLE
                }
                else -> {

                    if(paginas == actual){
                        binding.buprox.visibility = View.GONE
                        binding.buAtras.visibility = View.VISIBLE
                    }
                }
            }
        }

        binding.buAtras.setOnClickListener {
            actual--
            myViewModel.getListaComing("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", actual)
        }

        binding.buprox.setOnClickListener {
            actual++
            myViewModel.getListaComing("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", actual)
        }

        binding.recyclerComing.layoutManager = LinearLayoutManager(requireContext())
        adapter = AdapterUpComing()
        binding.recyclerComing.adapter = adapter

        myViewModel.livePeliComing.observe(viewLifecycleOwner){
            if (it != null) {
                adapter.updataComing(it)
            }
        }

        myViewModel.getListaComing("es-ES","5f7af1e971090ad23a762fcc923ac6ce",1 )

    }
}