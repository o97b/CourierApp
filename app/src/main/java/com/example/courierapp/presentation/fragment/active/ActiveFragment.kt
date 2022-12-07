package com.example.courierapp.presentation.fragment.active

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.courierapp.R
import com.example.courierapp.databinding.FragmentActiveBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ActiveFragment: Fragment(R.layout.fragment_active) {
    private var _binding: FragmentActiveBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ActiveViewModel by viewModels()


}