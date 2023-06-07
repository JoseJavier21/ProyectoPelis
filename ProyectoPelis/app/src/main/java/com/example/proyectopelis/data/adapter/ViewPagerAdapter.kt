package com.example.proyectopelis.data.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.proyectopelis.Fragments.FragmentPelisDetalles
import com.example.proyectopelis.Fragments.FragmentPelisVideos
import com.example.proyectopelis.ui.TopRated
import com.example.proyectopelis.ui.UpComing

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentPelisDetalles()
            1 -> FragmentPelisVideos()
            2 -> TopRated()
            else -> UpComing()
        }
    }
}