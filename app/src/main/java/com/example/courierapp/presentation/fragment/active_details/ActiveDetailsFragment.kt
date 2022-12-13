package com.example.courierapp.presentation.fragment.active_details

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.courierapp.R
import com.example.courierapp.databinding.FragmentActiveDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActiveDetailsFragment: Fragment(R.layout.fragment_active_details) {
    private var _binding: FragmentActiveDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ActiveDetailsViewModel by viewModels()


}