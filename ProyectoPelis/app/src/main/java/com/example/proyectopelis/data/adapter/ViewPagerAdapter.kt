package com.example.proyectopelis.data.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.proyectopelis.Fragments.FragmentPelisDetalles
import com.example.proyectopelis.Fragments.FragmentPelisVideos

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