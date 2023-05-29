package com.example.proyectopelis.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectopelis.R
import com.example.proyectopelis.databinding.FragmentPelisEnCineBinding

class PelisEnCine : Fragment() {

    private lateinit var binding:FragmentPelisEnCineBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentPelisEnCineBinding.inflate(inflater,container,false)
        return binding.root
    }


}