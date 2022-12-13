package com.example.courierapp.presentation.fragment.history

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.courierapp.R
import com.example.courierapp.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment: Fragment(R.layout.fragment_history) {
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HistoryViewModel by viewModels()


}