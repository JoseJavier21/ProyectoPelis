package com.example.proyectopelis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyectopelis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.fragmentContainerView)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.fragment1,
                R.id.fragment2,
                R.id.fragment3
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNavigationView.setupWithNavController(navController)

        setContentView(binding.root)



    }
}