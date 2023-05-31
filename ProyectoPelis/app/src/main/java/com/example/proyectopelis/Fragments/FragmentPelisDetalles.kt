package com.example.proyectopelis.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.example.proyectopelis.databinding.FragmentPelisDetallesBinding

class FragmentPelisDetalles : Fragment() {

    private var _binding: FragmentPelisDetallesBinding? = null
    private val binding get() = _binding!!

    private val viewModel by activityViewModels<ViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPelisDetallesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.peliSeleccionada.observe(viewLifecycleOwnere) {
            /*viewModel.getPelisDetalles("es-ES", it.results.id)
            viewModel.liveDataPelisVideos.observe(viewLifecycleOwner) {

            }*/
        }

        /*viewModel.getPelisNuevas.observe(viewLifecycleOwnere) {
            viewModel.getPelisVideos("es-ES", it.results.id)
            viewModel.liveDataPelisVideos.observe(viewLifecycleOwner) {

            }
        }

        viewModel.getPelisPuntuadas.observe(viewLifecycleOwnere) {
            viewModel.getPelisVideos("es-ES", it.results.id)
            viewModel.liveDataPelisVideos.observe(viewLifecycleOwner) {

            }
        }

        viewModel.getPelisPuntuadas.observe(viewLifecycleOwnere) {
            viewModel.getPelisVideos("es-ES", it.results.id)
            viewModel.liveDataPelisVideos.observe(viewLifecycleOwner) {

            }
        }*/
    }
}