package com.example.proyectopelis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyectopelis.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


        val navController= findNavController(this,R.id.fragmentContainerView)
        navController.setGraph(R.navigation.nav_graph)
        appBarConfiguration = AppBarConfiguration(navController.graph)


        val navView:BottomNavigationView=binding.bottomNavigationView

        val appBarConfiguration=AppBarConfiguration(
            setOf(
<<<<<<< HEAD
<<<<<<< HEAD
                R.id.fragment1,
                R.id.fragment2,
                R.id.fragment3,
                R.id.fragment4
=======
                R.id.upComing,
                R.id.topRated,
                R.id.pelisPopulares
>>>>>>> e18ade48dca65f9bf350f6ed011444d44c1d4237
=======
                R.id.pelisEnCine,
                R.id.pelisPopulares,
                R.id.topRated,
                R.id.upComing
>>>>>>> Francis
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        setContentView(binding.root)
    }


    override fun onSupportNavigateUp(): Boolean {

        val navController=findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration)||super.onSupportNavigateUp()

    }


}