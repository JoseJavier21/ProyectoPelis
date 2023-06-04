package com.example.proyectopelis.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopelis.R
import com.example.proyectopelis.ViewModel
import com.example.proyectopelis.data.adapter.AdapterRated
import com.example.proyectopelis.databinding.FragmentTopRatedBinding


class TopRated : Fragment() {

    private lateinit var binding: FragmentTopRatedBinding
    private lateinit var adapterRated: AdapterRated
    private val myViewModel: com.example.proyectopelis.ViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopRatedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_main, menu)

                val menuLupa = menu.findItem(R.id.app_bar_search)
                val lupa = menuLupa.actionView as SearchView
                lupa.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        // meter el filtro del adapter
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        // meter el filtro del adapter
                        return true
                    }

                })
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        }, viewLifecycleOwner, androidx.lifecycle.Lifecycle.State.RESUMED)


        binding.recyclerRated.layoutManager = LinearLayoutManager(requireContext())
        adapterRated = AdapterRated()
        binding.recyclerRated.adapter = adapterRated

        myViewModel.LivePeliRated.observe(viewLifecycleOwner){
            if (it != null){
                adapterRated.updateRated(it)
            }
        }

        //myViewModel.getListaRated("es-ES","5f7af1e971090ad23a762fcc923ac6ce",1 )


    }
}