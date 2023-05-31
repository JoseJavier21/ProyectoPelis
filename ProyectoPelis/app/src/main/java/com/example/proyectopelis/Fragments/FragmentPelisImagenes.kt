package com.example.proyectopelis.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectopelis.R

class FragmentPelisImagenes : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pelis_imagenes, container, false)
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