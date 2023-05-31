package com.example.proyectopelis.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD
<<<<<<< HEAD
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
=======
import androidx.fragment.app.activityViewModels
>>>>>>> e18ade48dca65f9bf350f6ed011444d44c1d4237
=======
import androidx.fragment.app.activityViewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
>>>>>>> Francis
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.proyectopelis.R
import com.example.proyectopelis.ViewModel
import com.example.proyectopelis.data.adapter.AdapterEnCines
import com.example.proyectopelis.data.adapter.AdapterPopulares
import com.example.proyectopelis.data.network.NowPlaying.ResultEnCine
import com.example.proyectopelis.data.network.Popular.ResultPopulares
import com.example.proyectopelis.databinding.FragmentPelisPopularesBinding


class PelisPopulares : Fragment() {

    private lateinit var binding:FragmentPelisPopularesBinding
<<<<<<< HEAD
<<<<<<< HEAD
    private lateinit var adapter: AdapterEnCines
=======
    private  lateinit var adapter: AdapterPopulares
    private val myviewModel:ViewModel by activityViewModels()

>>>>>>> e18ade48dca65f9bf350f6ed011444d44c1d4237

=======
    private  lateinit var adapter: AdapterPopulares
    private val myviewModel:ViewModel by activityViewModels()

>>>>>>> Francis
    private lateinit var listAdapter: AdapterPopulares

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentPelisPopularesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView=binding.rvPelisPopulares
<<<<<<< HEAD
<<<<<<< HEAD
        adapter= AdapterEnCines(object : AdapterEnCines.OnItemClickListener{
            override fun OnItemClick(resultEnCine: ResultEnCine) {
=======
        adapter= AdapterPopulares(object : AdapterPopulares.OnItemClickListener{
            override fun OnItemClick(resultPopulares: ResultPopulares) {
>>>>>>> e18ade48dca65f9bf350f6ed011444d44c1d4237
=======
        recyclerView.layoutManager= StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)
        adapter= AdapterPopulares(object : AdapterPopulares.OnItemClickListener{
            override fun OnItemClick(resultPopulares: ResultPopulares) {
>>>>>>> Francis
                findNavController().navigate(R.id.action_pelisPopulares_to_fragmentPelisDetalles)
            }
        })

        val layoutManager= LinearLayoutManager(requireContext())
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=adapter

<<<<<<< HEAD
<<<<<<< HEAD
=======

        myviewModel.pelisPopulares.observe(viewLifecycleOwner){
            if (it != null) {
                adapter.actualizaLista(it)
            }
        }

>>>>>>> Francis
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_main, menu)

                val menuItem = menu.findItem(R.id.app_bar_search)
                val searchView = menuItem.actionView as SearchView
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                    override fun onQueryTextSubmit(query: String?): Boolean {

                        listAdapter.filter.filter(query)
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {

                        listAdapter.filter.filter(newText)
                        return true
                    }
                })

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                return false
            }

        }, viewLifecycleOwner, androidx.lifecycle.Lifecycle.State.RESUMED)

<<<<<<< HEAD
=======
        myviewModel.pelisPopulares.observe(viewLifecycleOwner){
            if (it != null) {
                adapter.actualizaLista(it)
            }
        }
>>>>>>> e18ade48dca65f9bf350f6ed011444d44c1d4237

        myviewModel.getListaPopulares(idioma ="es-ES", pagina = 1)
=======
        myviewModel.getListaPopulares(idioma ="es-ES","5f7af1e971090ad23a762fcc923ac6ce", pagina = 1)
>>>>>>> Francis
    }
}