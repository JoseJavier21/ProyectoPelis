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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopelis.R
import com.example.proyectopelis.ViewModel
import com.example.proyectopelis.data.adapter.AdapterRated
import com.example.proyectopelis.data.network.TopRated.ResultRated
import com.example.proyectopelis.databinding.FragmentTopRatedBinding


class TopRated : Fragment() {

    private lateinit var binding: FragmentTopRatedBinding
    private lateinit var adapterRated: AdapterRated
    private val myViewModel: ViewModel by activityViewModels()


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
                        adapterRated.filter.filter(query)
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        adapterRated.filter.filter(newText)
                        return true
                    }

                })
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId==R.id.info){
                    findNavController().navigate(R.id.action_topRated_to_mapa)
                }
                return false
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

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
            myViewModel.getListaRated("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", actual)
        }

        binding.buprox.setOnClickListener {
            actual++
            myViewModel.getListaRated("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", actual)
        }


        binding.recyclerRated.layoutManager = LinearLayoutManager(requireContext())
        adapterRated = AdapterRated(object :AdapterRated.OnItemClickListener{
            override fun OnItemClick(resultRated: ResultRated) {
                findNavController().navigate(R.id.action_topRated_to_fragmentPelisDetalles)
                myViewModel.selectPeli3(resultRated)
            }

        })
        binding.recyclerRated.adapter = adapterRated

        myViewModel.LivePeliRated.observe(viewLifecycleOwner){
            binding.swipe.isRefreshing=false
            if (it != null){
                adapterRated.updateRated(it)
            }
        }

        binding.swipe.setOnRefreshListener {
            myViewModel.getListaRated("es-ES","5f7af1e971090ad23a762fcc923ac6ce",1)
        }

        myViewModel.getListaRated("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", actual)


    }
}