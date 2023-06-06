package com.example.proyectopelis.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.proyectopelis.R
import com.example.proyectopelis.ViewModel
import com.example.proyectopelis.data.adapter.AdapterPopulares
import com.example.proyectopelis.data.network.NowPlaying.ResultEnCine
import com.example.proyectopelis.data.network.Popular.ResultPopulares
import com.example.proyectopelis.databinding.FragmentPelisPopularesBinding


class PelisPopulares : Fragment() {

    private lateinit var binding:FragmentPelisPopularesBinding
    private  lateinit var adapter: AdapterPopulares
    private val myviewModel:ViewModel by activityViewModels()
    private var pagina=1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentPelisPopularesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myviewModel.pelisEnCine.observe(viewLifecycleOwner){
            adapter.actualizaLista(it as ArrayList<ResultPopulares?>)
        }

        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_main, menu)

                val menuItem = menu.findItem(R.id.app_bar_search)
                val searchView = menuItem.actionView as SearchView
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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
        },viewLifecycleOwner,androidx.lifecycle.Lifecycle.State.RESUMED)

            val recyclerView=binding.rvPelisPopulares
            recyclerView.layoutManager= StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)

            adapter= AdapterPopulares(object : AdapterPopulares.OnItemClickListener{
                override fun OnItemClick(resultPopulares: ResultPopulares) {
                    findNavController().navigate(R.id.action_pelisPopulares_to_fragmentPelisDetalles)
                }
            })

            val layoutManager= LinearLayoutManager(requireContext())
            recyclerView.layoutManager=layoutManager
            recyclerView.adapter=adapter


            myviewModel.pelisPopu.observe(viewLifecycleOwner){
                val totalPaginas=it.totalPages

                if (totalPaginas == 1) {
                    binding.btnIzq.visibility = View.GONE
                    binding.btnDrch.visibility = View.GONE
                } else {
                    if (pagina == 1) {
                        binding.btnIzq.visibility = View.GONE
                    } else {
                        binding.btnIzq.visibility = View.VISIBLE
                    }
                }
                if (pagina == totalPaginas) {
                    binding.btnDrch.visibility = View.GONE
                } else {
                    binding.btnDrch.visibility = View.VISIBLE
                }

                binding.btnIzq.setOnClickListener {
                    pagina--
                    myviewModel.getListaPopulares("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", pagina)
                }

                binding.btnDrch.setOnClickListener {
                    pagina++
                    myviewModel.getListaPopulares("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", pagina)
                }
            }

        myviewModel.getListaPopulares(idioma ="es-ES","5f7af1e971090ad23a762fcc923ac6ce", pagina = 1)

            myviewModel.pelisPopulares.observe(viewLifecycleOwner){
                if (it != null) {
                    adapter.actualizaLista(it)
                }
            }
            myviewModel.getListaPopulares(idioma ="es-ES","5f7af1e971090ad23a762fcc923ac6ce", pagina = 1)
        }
    }