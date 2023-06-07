package com.example.proyectopelis.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.example.proyectopelis.R
import com.example.proyectopelis.databinding.FragmentPelisDetallesBinding

class FragmentPelisDetalles : Fragment() {

    private lateinit var binding: FragmentPelisDetallesBinding

    private val viewModel by activityViewModels<ViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPelisDetallesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /*viewModel.getPelisPopulares.observe(viewLifecycleOwnere) {
            viewModel.getPelisVideos("481ea8c2e7722a6ef472f71742f4b90c", "es-ES", it.results.id)
            viewModel.liveDataPelisVideos.observe(viewLifecycleOwner) {

            }
        }

        viewModel.getPelisNuevas.observe(viewLifecycleOwnere) {
            viewModel.getPelisVideos("481ea8c2e7722a6ef472f71742f4b90c", "es-ES", it.results.id)
            viewModel.liveDataPelisVideos.observe(viewLifecycleOwner) {

            }
        }

        viewModel.getPelisPuntuadas.observe(viewLifecycleOwnere) {
            viewModel.getPelisVideos("481ea8c2e7722a6ef472f71742f4b90c", "es-ES", it.results.id)
            viewModel.liveDataPelisVideos.observe(viewLifecycleOwner) {

            }
        }

        viewModel.getPelisPuntuadas.observe(viewLifecycleOwnere) {
            viewModel.getPelisVideos("481ea8c2e7722a6ef472f71742f4b90c", "es-ES", it.results.id)
            viewModel.liveDataPelisVideos.observe(viewLifecycleOwner) {

            }
        }*/
    }
}

/*
https://www.youtube.com/watch?v=//Df00ZNYEcAY
carrusel con fotos
el enlace youtbe con boton
 */