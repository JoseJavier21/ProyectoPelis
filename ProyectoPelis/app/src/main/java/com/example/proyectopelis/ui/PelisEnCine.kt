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
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectopelis.R
import com.example.proyectopelis.ViewModel
import com.example.proyectopelis.data.adapter.AdapterEnCines
import com.example.proyectopelis.data.network.NowPlaying.ResultEnCine
import com.example.proyectopelis.databinding.FragmentPelisEnCineBinding

class PelisEnCine : Fragment() {

    private lateinit var binding:FragmentPelisEnCineBinding
    //private  lateinit var adapter:AdapterEnCines
    private  val myviewModel by activityViewModels<ViewModel> {
        ViewModel.MyViewModelFactory(requireContext())
    }

    private lateinit var binding: FragmentPelisEnCineBinding
    private lateinit var adapter: AdapterEnCines
    private val myviewModel: ViewModel by activityViewModels()
    private var pagina = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPelisEnCineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView=binding.rvPelisCine

        val adapter=AdapterEnCines(object : AdapterEnCines.OnItemClickListener{
            override fun OnItemClick(resultEnCine: ResultEnCine) {
                myviewModel.peliSelecionada.value = resultEnCine
                findNavController().navigate(R.id.action_pelisEnCine_to_fragmentPelisDetalles)
            }
        })

        val layoutManager=LinearLayoutManager(requireContext())

        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=adapter

        myviewModel.getListaEnCines("es-ES","5f7af1e971090ad23a762fcc923ac6ce",1)

        //myviewModel.getPelisDetalles("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", 634649)

        myviewModel.pelisEnCine.observe(viewLifecycleOwner){
            if (it != null) {
                adapter.actualizaLista2(it)
            }
        }

            requireActivity().addMenuProvider(object : MenuProvider {
        myviewModel.pelisEnCine.observe(viewLifecycleOwner) {
            adapter.actualizaLista2(it as ArrayList<ResultEnCine?>)
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
                if (menuItem.itemId==R.id.info){
                    findNavController().navigate(R.id.action_pelisEnCine_to_mapa)
                }
                return false
            }
        }, viewLifecycleOwner, androidx.lifecycle.Lifecycle.State.RESUMED)

        val recyclerView = binding.rvPelisCine
        recyclerView.layoutManager = StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)



        //recyclerView.layoutManager=StaggeredGridLayoutManager(1,RecyclerView.VERTICAL)









        adapter = AdapterEnCines(object : AdapterEnCines.OnItemClickListener {
            override fun OnItemClick(resultEnCine: ResultEnCine) {
                findNavController().navigate(R.id.action_pelisEnCine_to_fragmentPelisDetalles)
                myviewModel.selectPeli(resultEnCine)
            }
        })

        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter


        myviewModel.pelisCine.observe(viewLifecycleOwner) {
            val totalPaginas = it.totalPages

            if (totalPaginas == 1) {
                binding.botonizq.visibility = View.GONE
                binding.botondrcha.visibility = View.GONE
            } else {
                if (pagina == 1) {
                    binding.botonizq.visibility = View.GONE
                } else {
                    binding.botonizq.visibility = View.VISIBLE
                }
            }

            if (pagina == totalPaginas) {
                binding.botondrcha.visibility = View.GONE
            } else {
                binding.botondrcha.visibility = View.VISIBLE
            }

            binding.botonizq.setOnClickListener {
                pagina--
                myviewModel.getListaEnCines("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", pagina)
            }

            binding.botondrcha.setOnClickListener {
                pagina++
                myviewModel.getListaEnCines("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", pagina)
            }
        }

        myviewModel.pelisEnCine.observe(viewLifecycleOwner){
            binding.swipe.isRefreshing = false
            if (it != null) {
                adapter.actualizaLista2(it)
            }
        }
        myviewModel.getListaEnCines("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", 1)

        binding.swipe.setOnRefreshListener {
            myviewModel.getListaEnCines("es-ES","5f7af1e971090ad23a762fcc923ac6ce",1)
        }
        myviewModel.getListaEnCines("es-ES","5f7af1e971090ad23a762fcc923ac6ce",1)
    }
}