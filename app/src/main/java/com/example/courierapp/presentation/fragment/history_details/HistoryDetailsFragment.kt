package com.example.courierapp.presentation.fragment.history_details

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.courierapp.R
import com.example.courierapp.databinding.FragmentHistoryDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryDetailsFragment: Fragment(R.layout.fragment_history_details) {
    private var _binding: FragmentHistoryDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HistoryDetailsViewModel by viewModels()

}