package com.example.proyectopelis.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
//import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectopelis.databinding.FragmentPelisDetallesBinding
import com.example.proyectopelis.ViewModel

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

        /*viewModel.peliSelecionada.observe(viewLifecycleOwner) {
                it.id?.let { it1 ->
                    viewModel.getPelisDetalles("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", it1)
                    viewModel.getPelisVideos("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", it1)
                    viewModel.getPelisImagenes("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", it1)
                }
            viewModel.liveDataPelisDetalles.observe(viewLifecycleOwner) {
                if (it != null) {
                    binding.name.text = it.original_title
                    binding.sinapsis.text = it.overview
                    binding.genres.text = it.genres.get(0).name
                    binding.budget.text = it.budget.toString()
                    binding.vote.text = it.vote_average.toString()
                    binding.web.text = it.homepage
                    binding.video.text = "https://image.tmdb.org/t/p/original" + it.backdrop_path
                }
            }

            viewModel.liveDataPelisVideos.observe(viewLifecycleOwner) {
                if (it != null) {
                    binding.video.text = "https://www.youtube.com/watch?v=" + it.results.get(0).key
                }
            }

            viewModel.liveDataPelisImagenes.observe(viewLifecycleOwner) {
                if (it != null) {
                    //binding.foto = "https://image.tmdb.org/t/p/original" + it.logos.get(0).file_path
                    //binding.carrusel = it.posters
                }
            }
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
        }*/*/
    }
}