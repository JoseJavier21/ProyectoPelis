package com.example.proyectopelis.ui.viewpageradapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.proyectopelis.ui.pelisdetalles.FragmentPelisDetalles
import com.example.proyectopelis.ui.pelisvideos.FragmentPelisVideos

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentPelisDetalles()
            else -> FragmentPelisVideos()
        }
    }
}