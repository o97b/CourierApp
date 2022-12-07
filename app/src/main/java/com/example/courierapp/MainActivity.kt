package com.example.courierapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import com.example.courierapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            viewModel.isLoading.value == true
        }

        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        viewModel.isLoading.observe(this@MainActivity) { isLoadingValue ->
            if (!isLoadingValue) startNavigation()
        }
    }

    private fun startNavigation() {
        val token = viewModel.accessToken.value
        token?.let {
            val navController = this@MainActivity.findNavController(R.id.fragmentContainer)
            navController.navigate(R.id.activeFragment)
        }
    }

}