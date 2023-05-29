package com.example.proyectopelis.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectopelis.R
import com.example.proyectopelis.databinding.FragmentPelisPopularesBinding


class PelisPopulares : Fragment() {

    private lateinit var binding:FragmentPelisPopularesBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentPelisPopularesBinding.inflate(inflater,container,false)
        return binding.root
    }


}