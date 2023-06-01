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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.proyectopelis.R
import com.example.proyectopelis.data.adapter.AdapterRated
import com.example.proyectopelis.databinding.FragmentTopRatedBinding


class TopRated : Fragment() {

    private lateinit var binding: FragmentTopRatedBinding
    private lateinit var adapter: AdapterRated
    private val myviewModel: ViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopRatedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//         requireActivity().addMenuProvider(object : MenuProvider{
//            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
//                menuInflater.inflate(R.menu.menu, menu)
//
//                val menuItem = menu.findItem(R.id.app_bar_search)
//                val searchView = menuItem.actionView as SearchView
//                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//
//                    override fun onQueryTextSubmit(query: String?): Boolean {
//
//                        listAdapter.filter.filter(query)
//                        return true
//                    }
//
//                    //override fun onQueryTextChange(newText: String?): Boolean {
//
//                    //                        listAdapter.filter.filter(newText)
//                        return true
//                    //}
//                    override fun onQueryTextSubmit(query: String?): Boolean {
//                        TODO("Not yet implemented")
//                    }
//
//                    override fun onQueryTextChange(newText: String?): Boolean {
//                        TODO("Not yet implemented")
//                    }
//
//                })
//
//            }
//
//            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
//
//                return false
//            }
//
//
//        }, viewLifecycleOwner, androidx.lifecycle.Lifecycle.State.RESUMED)


//        val recyclerView = binding.recyclerRated
//
//        binding.recyclerRated.layoutManager = LinearLayoutManager(requireContext())
//
//        recyclerView.findNavController().navigate(R.id.action_topRated_to_fragmentPelisDetalles)
//        binding.recyclerRated.adapter = AdapterRated()
//        recyclerView.adapter = adapter



        //myviewModel.getListaRated("es-ES","5f7af1e971090ad23a762fcc923ac6ce", 1)
    }
}