package com.example.proyectopelis.Fragments

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
import com.example.proyectopelis.R
import com.example.proyectopelis.databinding.FragmentTopRatedBinding


class TopRated : Fragment() {

    private lateinit var binding: FragmentTopRatedBinding

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

                val menuItem = menu.findItem(R.id.app_bar_search)
                val searchView = menuItem.actionView as SearchView
//                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//                    override fun onQueryTextSubmit(query: String?): Boolean {
//
//                        listAdapter.filter.filter(query)
//                        return true
//                    }
//
//                    override fun onQueryTextChange(newText: String?): Boolean {
//
//                        listAdapter.filter.filter(newText)
//                        return true
//                    }
//
//
//                })

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                return false
            }


        }, viewLifecycleOwner, androidx.lifecycle.Lifecycle.State.RESUMED)


    }
}