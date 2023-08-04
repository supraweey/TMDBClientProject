package com.android.supraweey.tmdbclient.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.android.supraweey.tmdbclient.R
import com.android.supraweey.tmdbclient.databinding.ActivityPopularBinding

class PopularActivity : AppCompatActivity() {
    //    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var binding: ActivityPopularBinding
    private val navController: NavController
        get() = findNavController(R.id.moviePopularContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPopularBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra("ID_KEY")?.let {
            Toast.makeText(this, "ID is $it", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, PopularActivity::class.java)
            context.startActivity(intent)
        }
    }

//    private fun navigateToPopular() {
//        navController.navigate(R.id.popularListFragment)
//    }

}