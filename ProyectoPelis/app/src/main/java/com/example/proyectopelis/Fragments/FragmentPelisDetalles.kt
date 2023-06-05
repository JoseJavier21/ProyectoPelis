package com.example.proyectopelis.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
//import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopelis.databinding.FragmentPelisDetallesBinding
import com.example.proyectopelis.ViewModel
import com.example.proyectopelis.data.adapter.CarruselAdapter
import com.example.proyectopelis.data.adapter.CarruselAdapterPager
import com.example.proyectopelis.data.network.Imagenes.Poster

class FragmentPelisDetalles : Fragment() {

    private var _binding: FragmentPelisDetallesBinding? = null
    private val binding get() = _binding!!

    private val viewModel by activityViewModels<ViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPelisDetallesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.peliSelecionada.observe(viewLifecycleOwner) {
            when {
                it != null -> {
                    it.id?.let { it1 ->
                        viewModel.getPelisDetalles("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", it1)
                        viewModel.getPelisVideos("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", it1)
                        viewModel.getPelisImagenes("es-ES", "5f7af1e971090ad23a762fcc923ac6ce", it1)
                    }
                    viewModel.liveDataPelisDetalles.observe(viewLifecycleOwner) {
                        if (it != null) {
                            binding.name.text = it.original_title
                            binding.sinapsis.text = it.overview
                            binding.budget.text = it.budget.toString()
                            binding.vote.text = it.vote_average.toString()
                            binding.web.text = it.homepage
                            //binding.genres.text = it.genres.get(0).name
                            val genresText = StringBuilder()
                            for (genre in it.genres) {
                                genresText.append(genre.name).append(", ")
                            }
                            if (genresText.isNotEmpty()) {
                                genresText.deleteCharAt(genresText.length - 1)
                            }
                            binding.genres.text = genresText.toString()
                            //binding.video.text = "https://image.tmdb.org/t/p/original" + it.backdrop_path
                        }
                    }

                    viewModel.liveDataPelisVideos.observe(viewLifecycleOwner) {
                        if (it != null) {
                            binding.video.text =
                                "https://www.youtube.com/watch?v=" + it.results.get(0).key
                        }
                    }

                    viewModel.liveDataPelisImagenes.observe(viewLifecycleOwner) {
                        if (it != null) {
                            val posters = it.posters.map { poster -> poster.file_path }
                            val carruselAdaterPager = CarruselAdapterPager(posters)
                            binding.viewpager.adapter = carruselAdaterPager
                            //binding.foto = "https://image.tmdb.org/t/p/original" + it.logos.get(0).file_path
                            //binding.carrusel = it.posters

                        }
                    }
                }

                /*viewModel.getPelisNuevas.value != null -> {
                    viewModel.getPelisNuevas.observe(viewLifecycleOwnere) {
                        it.id?.let { it1 ->
                            viewModel.getPelisDetalles(
                                "es-ES",
                                "5f7af1e971090ad23a762fcc923ac6ce",
                                it1
                            )
                            viewModel.getPelisVideos(
                                "es-ES",
                                "5f7af1e971090ad23a762fcc923ac6ce",
                                it1
                            )
                            viewModel.getPelisImagenes(
                                "es-ES",
                                "5f7af1e971090ad23a762fcc923ac6ce",
                                it1
                            )
                        }
                        viewModel.liveDataPelisDetalles.observe(viewLifecycleOwner) {
                            if (it != null) {
                                binding.name.text = it.original_title
                                binding.sinapsis.text = it.overview
                                binding.budget.text = it.budget.toString()
                                binding.vote.text = it.vote_average.toString()
                                binding.web.text = it.homepage
                                //binding.genres.text = it.genres.get(0).name
                                val genresText = StringBuilder()
                                for (genre in it.genres) {
                                    genresText.append(genre.name).append(", ")
                                }
                                if (genresText.isNotEmpty()) {
                                    genresText.deleteCharAt(genresText.length - 1)
                                }
                                binding.genres.text = genresText.toString()
                                //binding.video.text = "https://image.tmdb.org/t/p/original" + it.backdrop_path
                            }
                        }

                        viewModel.liveDataPelisVideos.observe(viewLifecycleOwner) {
                            if (it != null) {
                                binding.video.text =
                                    "https://www.youtube.com/watch?v=" + it.results.get(0).key
                            }
                        }

                        viewModel.liveDataPelisImagenes.observe(viewLifecycleOwner) {
                            if (it != null) {
                                val posters = it.posters.map { poster -> poster.file_path }
                                val carruselAdaterPager = CarruselAdapterPager(posters)
                                binding.viewpager.adapter = carruselAdaterPager
                                //binding.foto = "https://image.tmdb.org/t/p/original" + it.logos.get(0).file_path
                                //binding.carrusel = it.posters

                            }
                        }
                    }
                }

                viewModel.getPelisPuntuadas.value != null -> {
                    viewModel.getPelisPuntuadas.observe(viewLifecycleOwnere) {
                        it.id?.let { it1 ->
                            viewModel.getPelisDetalles(
                                "es-ES",
                                "5f7af1e971090ad23a762fcc923ac6ce",
                                it1
                            )
                            viewModel.getPelisVideos(
                                "es-ES",
                                "5f7af1e971090ad23a762fcc923ac6ce",
                                it1
                            )
                            viewModel.getPelisImagenes(
                                "es-ES",
                                "5f7af1e971090ad23a762fcc923ac6ce",
                                it1
                            )
                        }
                        viewModel.liveDataPelisDetalles.observe(viewLifecycleOwner) {
                            if (it != null) {
                                binding.name.text = it.original_title
                                binding.sinapsis.text = it.overview
                                binding.budget.text = it.budget.toString()
                                binding.vote.text = it.vote_average.toString()
                                binding.web.text = it.homepage
                                //binding.genres.text = it.genres.get(0).name
                                val genresText = StringBuilder()
                                for (genre in it.genres) {
                                    genresText.append(genre.name).append(", ")
                                }
                                if (genresText.isNotEmpty()) {
                                    genresText.deleteCharAt(genresText.length - 1)
                                }
                                binding.genres.text = genresText.toString()
                                //binding.video.text = "https://image.tmdb.org/t/p/original" + it.backdrop_path
                            }
                        }

                        viewModel.liveDataPelisVideos.observe(viewLifecycleOwner) {
                            if (it != null) {
                                binding.video.text =
                                    "https://www.youtube.com/watch?v=" + it.results.get(0).key
                            }
                        }

                        viewModel.liveDataPelisImagenes.observe(viewLifecycleOwner) {
                            if (it != null) {
                                val posters = it.posters.map { poster -> poster.file_path }
                                val carruselAdaterPager = CarruselAdapterPager(posters)
                                binding.viewpager.adapter = carruselAdaterPager
                                //binding.foto = "https://image.tmdb.org/t/p/original" + it.logos.get(0).file_path
                                //binding.carrusel = it.posters

                            }
                        }
                    }
                }

                viewModel.getPelisPopulares.value != null -> {
                    viewModel.getPelisPopulares.observe(viewLifecycleOwnere) {
                        it.id?.let { it1 ->
                            viewModel.getPelisDetalles(
                                "es-ES",
                                "5f7af1e971090ad23a762fcc923ac6ce",
                                it1
                            )
                            viewModel.getPelisVideos(
                                "es-ES",
                                "5f7af1e971090ad23a762fcc923ac6ce",
                                it1
                            )
                            viewModel.getPelisImagenes(
                                "es-ES",
                                "5f7af1e971090ad23a762fcc923ac6ce",
                                it1
                            )
                        }
                        viewModel.liveDataPelisDetalles.observe(viewLifecycleOwner) {
                            if (it != null) {
                                binding.name.text = it.original_title
                                binding.sinapsis.text = it.overview
                                binding.budget.text = it.budget.toString()
                                binding.vote.text = it.vote_average.toString()
                                binding.web.text = it.homepage
                                //binding.genres.text = it.genres.get(0).name
                                val genresText = StringBuilder()
                                for (genre in it.genres) {
                                    genresText.append(genre.name).append(", ")
                                }
                                if (genresText.isNotEmpty()) {
                                    genresText.deleteCharAt(genresText.length - 1)
                                }
                                binding.genres.text = genresText.toString()
                                //binding.video.text = "https://image.tmdb.org/t/p/original" + it.backdrop_path
                            }
                        }

                        viewModel.liveDataPelisVideos.observe(viewLifecycleOwner) {
                            if (it != null) {
                                binding.video.text =
                                    "https://www.youtube.com/watch?v=" + it.results.get(0).key
                            }
                        }

                        viewModel.liveDataPelisImagenes.observe(viewLifecycleOwner) {
                            if (it != null) {
                                val posters = it.posters.map { poster -> poster.file_path }
                                val carruselAdaterPager = CarruselAdapterPager(posters)
                                binding.viewpager.adapter = carruselAdaterPager
                                //binding.foto = "https://image.tmdb.org/t/p/original" + it.logos.get(0).file_path
                                //binding.carrusel = it.posters

                            }
                        }
                    }
                }*/
            }
        }

        val recyclerView = binding.recyclerview
        var glm = GridLayoutManager(requireContext(), 1, RecyclerView.HORIZONTAL, false)
        recyclerView.layoutManager = glm
        val adapter = CarruselAdapter()
        //var adaptador = CarruselAdapterPager()
        //val viewpager = binding.viewpager
        //viewpager.adapter = adaptador
        recyclerView.adapter = adapter
        //adapter.update()
        adapter.setOnItemClickListener { poster ->
            val index = adapter.getPosition(poster)
            //val index = dataList.indexOf(poster)
            //val index = adapter.getDataList().indexOf(poster)
            binding.viewpager.setCurrentItem(index, true)
        }
        //adaptador = CarruselAdapterPager(carrusel.map { it.})
        //viewpager.adapter = adaptador
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}