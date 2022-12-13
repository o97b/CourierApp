package com.example.courierapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.courierapp.databinding.ActivityMainBinding
import com.example.courierapp.domain.model.LoginBody
import com.example.courierapp.presentation.fragment.active.ActiveFragment
import com.example.courierapp.presentation.fragment.history.HistoryFragment
import com.example.courierapp.presentation.fragment.login.LoginFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), LoginFragment.NavCallback {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
            .also { setContentView(it.root) }
        navController = this@MainActivity.findNavController(R.id.fragmentContainer)

        setSplashScreen()
        setBar()
        setFragmentListener()

        startNavigation()
    }

    /***
     * Starting functions
     */

    private fun setSplashScreen() {
        installSplashScreen().setKeepOnScreenCondition {
                viewModel.isLoading.value == true
            }
    }

    private fun setBar() {
        val navView = binding.navView
        navView.setupWithNavController(navController)
    }

    private fun setFragmentListener() {
        supportFragmentManager.registerFragmentLifecycleCallbacks(
            object : FragmentManager.FragmentLifecycleCallbacks() {
                override fun onFragmentViewCreated(
                    fm: FragmentManager,
                    f: Fragment,
                    v: View,
                    savedInstanceState: Bundle?
                ) {
                    super.onFragmentViewCreated(fm, f, v, savedInstanceState)
                    if (f is NavHostFragment) return
                    currentFragment = f
                    updateContainerUi()
                }
            },
            true
        )
    }

    private fun updateContainerUi() {
        when(currentFragment) {
            is LoginFragment -> {
                binding.navView.visibility = View.GONE
            }
            is ActiveFragment, is HistoryFragment -> {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                supportActionBar?.setDisplayShowHomeEnabled(false)
                binding.navView.visibility = View.VISIBLE
            }
            else -> {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                supportActionBar?.setDisplayShowHomeEnabled(true)
                binding.navView.visibility = View.VISIBLE
            }
        }
    }

    private fun startNavigation() {
        viewModel.isLoading.observe(this@MainActivity) { isLoading ->
            if (!isLoading) {
                val token = viewModel.accessToken.value
                if (token == null) {
                    navController.navigate(R.id.loginFragment)
                }
            }
        }
    }

    /***
     * Implementation of navigation callbacks
     */

    // LoginFragment

    override fun onLoginClicked(isCorrectLogin: Boolean, isExistingLogin: Boolean) {
        navController.navigate(
            if (isCorrectLogin) R.id.activeFragment
            else R.id.forgotPassFragment
        )
    }

}