package com.example.proyectopelis.Fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopelis.databinding.FragmentPelisDetallesBinding
import com.example.proyectopelis.ViewModel
import com.example.proyectopelis.data.adapter.CarruselAdapter
import com.example.proyectopelis.data.adapter.CarruselAdapterPager

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

        viewModel.peliSelecionada1.observe(viewLifecycleOwner) {
            when {
                it != null -> {
                    it.id?.let { it1 ->
                        viewModel.getPelisDetalles(it1, "es-ES", "5f7af1e971090ad23a762fcc923ac6ce")
                        viewModel.getPelisVideos(it1, "es-ES", "5f7af1e971090ad23a762fcc923ac6ce")
                        viewModel.getPelisImagenes(it1, "es", "5f7af1e971090ad23a762fcc923ac6ce")
                    }
                    viewModel.liveDataPelisDetalles.observe(viewLifecycleOwner) {
                        if (it != null) {
                            binding.name.text = it.original_title
                            binding.sinapsis.text = it.overview
                            binding.budget.text = it.budget.toString() + "$"
                            binding.vote.text = it.vote_average.toString() + "/10"
                            val homepage = it.homepage
                            binding.web.setOnClickListener {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(homepage))
                                startActivity(intent)
                            }
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
                            if (it.results.isNotEmpty()) {
                                val results = it.results.get(0).key
                                binding.video.setOnClickListener {
                                    val intent = Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse("https://www.youtube.com/watch?v=" + results)
                                    )
                                    startActivity(intent)

                                }
                            } else {
                                binding.video.text = "Video no disponible"
                            }

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
        }

        viewModel.peliSelecionada2.observe(viewLifecycleOwner) {
            when {
                it != null -> {
                    it.id?.let { it1 ->
                        viewModel.getPelisDetalles(it1, "es-ES", "5f7af1e971090ad23a762fcc923ac6ce")
                        viewModel.getPelisVideos(it1, "es-ES", "5f7af1e971090ad23a762fcc923ac6ce")
                        viewModel.getPelisImagenes(it1, "es", "5f7af1e971090ad23a762fcc923ac6ce")
                    }
                    viewModel.liveDataPelisDetalles.observe(viewLifecycleOwner) {
                        if (it != null) {
                            binding.name.text = it.original_title
                            binding.sinapsis.text = it.overview
                            binding.budget.text = it.budget.toString() + "$"
                            binding.vote.text = it.vote_average.toString() + "/10"
                            val homepage = it.homepage
                            binding.web.setOnClickListener {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(homepage))
                                startActivity(intent)
                            }
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
                            val results = it.results.get(0).key
                            binding.video.setOnClickListener {
                                val intent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("https://www.youtube.com/watch?v=" + results)
                                )
                                startActivity(intent)

                            }

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
        }

        viewModel.peliSeleccionada3.observe(viewLifecycleOwner) {
            when {
                it != null -> {
                    it.id?.let { it1 ->
                        viewModel.getPelisDetalles(it1, "es-ES", "5f7af1e971090ad23a762fcc923ac6ce")
                        viewModel.getPelisVideos(it1, "es-ES", "5f7af1e971090ad23a762fcc923ac6ce")
                        viewModel.getPelisImagenes(it1, "es", "5f7af1e971090ad23a762fcc923ac6ce")
                    }
                    viewModel.liveDataPelisDetalles.observe(viewLifecycleOwner) {
                        if (it != null) {
                            binding.name.text = it.original_title
                            binding.sinapsis.text = it.overview
                            binding.budget.text = it.budget.toString() + "$"
                            binding.vote.text = it.vote_average.toString() + "/10"
                            val homepage = it.homepage
                            binding.web.setOnClickListener {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(homepage))
                                startActivity(intent)
                            }
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
                            val results = it.results.get(0).key
                            binding.video.setOnClickListener {
                                val intent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("https://www.youtube.com/watch?v=" + results)
                                )
                                startActivity(intent)

                            }

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
        }

        viewModel.peliSeleccionada4.observe(viewLifecycleOwner) {
            when {
                it != null -> {
                    it.id?.let { it1 ->
                        viewModel.getPelisDetalles(it1, "es-ES", "5f7af1e971090ad23a762fcc923ac6ce")
                        viewModel.getPelisVideos(it1, "es-ES", "5f7af1e971090ad23a762fcc923ac6ce")
                        viewModel.getPelisImagenes(it1, "es", "5f7af1e971090ad23a762fcc923ac6ce")
                    }
                    viewModel.liveDataPelisDetalles.observe(viewLifecycleOwner) {
                        if (it != null) {
                            binding.name.text = it.original_title
                            binding.sinapsis.text = it.overview
                            binding.budget.text = it.budget.toString() + "$"
                            binding.vote.text = it.vote_average.toString() + "/10"
                            val homepage = it.homepage
                            binding.web.setOnClickListener {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(homepage))
                                startActivity(intent)
                            }
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
                            val results = it.results.get(0).key
                            binding.video.setOnClickListener {
                                val intent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("https://www.youtube.com/watch?v=" + results)
                                )
                                startActivity(intent)

                            }

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
        viewModel.liveDataPelisImagenes.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.update(it.posters)
            }
        }
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