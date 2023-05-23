package com.android.supraweey.tmdbclient.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.android.supraweey.tmdbclient.R
import com.android.supraweey.tmdbclient.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var binding: ActivityMainBinding
    private val navController: NavController
        get() = findNavController(R.id.moviePopularContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra("ID_KEY")?.let {
            Toast.makeText(this, "ID is $it", Toast.LENGTH_SHORT).show()
        }
    }

//    private fun navigateToPopular() {
//        navController.navigate(R.id.popularListFragment)
//    }

}