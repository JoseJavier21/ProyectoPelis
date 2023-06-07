package com.example.proyectopelis.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.proyectopelis.R
import com.example.proyectopelis.databinding.FragmentMapaBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class Mapa : Fragment(),OnMapReadyCallback {

    private lateinit var binding: FragmentMapaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMapaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapaFragment = (childFragmentManager.findFragmentById(R.id.map)) as SupportMapFragment
        mapaFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        map.mapType= GoogleMap.MAP_TYPE_HYBRID
        map.isTrafficEnabled=true

        val ajustes=map.uiSettings
        ajustes.isZoomControlsEnabled=true
        //LINARES
        val ubicacion= LatLng(38.096218581351714, -3.6356574287550614)
        val ubiCineL= LatLng(38.099196204651925, -3.6345647413094917)
        val ubiCineJ=LatLng(37.78277860153554, -3.768132315998371)

        map.setOnMapLoadedCallback {
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(ubicacion,10f))
            map.setOnPoiClickListener {
                Toast.makeText(requireContext(),"Esto es ${it.name}", Toast.LENGTH_LONG).show()
            }

            val opciones=
                MarkerOptions()
                    .title("Cine Linares")
                    .position(ubiCineL)
                    .flat(true)
            //.icon(BitmapDescriptorFactory.fromResource(R.drawable.baseline_movie_24))
            val jaen=
                MarkerOptions()
                    .title("Cine Jaen")
                    .position(ubiCineJ)
                    .flat(true)
            map.addMarker(opciones)
            map.addMarker(jaen)
        }
    }
}