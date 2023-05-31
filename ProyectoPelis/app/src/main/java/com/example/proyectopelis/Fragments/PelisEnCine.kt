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
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
=======
import androidx.fragment.app.activityViewModels
>>>>>>> e18ade48dca65f9bf350f6ed011444d44c1d4237
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectopelis.R
import com.example.proyectopelis.ViewModel
import com.example.proyectopelis.data.adapter.AdapterEnCines
import com.example.proyectopelis.data.network.NowPlaying.ResultEnCine
import com.example.proyectopelis.databinding.FragmentPelisEnCineBinding

class PelisEnCine : Fragment() {

    private lateinit var binding:FragmentPelisEnCineBinding
<<<<<<< HEAD
    private lateinit var adapter:AdapterEnCines

=======
    private  lateinit var adapter:AdapterEnCines
    private  val myviewModel:ViewModel by activityViewModels()
>>>>>>> e18ade48dca65f9bf350f6ed011444d44c1d4237


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentPelisEnCineBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView=binding.rvPelisCine
        adapter=AdapterEnCines(object : AdapterEnCines.OnItemClickListener{
            override fun OnItemClick(resultEnCine: ResultEnCine) {
                findNavController().navigate(R.id.action_pelisEnCine_to_fragmentPelisDetalles)

            }

        })
        val layoutManager=LinearLayoutManager(requireContext())
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=adapter

<<<<<<< HEAD
        myviewModel.pelisEnCine.observe(viewLifecycleOwner){
            adapter.actualizaLista2(it as ArrayList<ResultEnCine>)
=======
<<<<<<< HEAD
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_main, menu)

                val menuItem = menu.findItem(R.id.app_bar_search)
                val searchView = menuItem.actionView as SearchView
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                    override fun onQueryTextSubmit(query: String?): Boolean {

                        adapter.filter.filter(query)
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {

                        adapter.filter.filter(newText)
                        return true
                    }


                })

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                return false
            }


        }, viewLifecycleOwner, androidx.lifecycle.Lifecycle.State.RESUMED)
=======
        myviewModel.pelisEnCine.observe(viewLifecycleOwner){
            if (it != null) {
                adapter.actualizaLista2(it)
            }
>>>>>>> pre-main
        }

        myviewModel.getListaEnCines("es-ES",1)

>>>>>>> e18ade48dca65f9bf350f6ed011444d44c1d4237

    }
}