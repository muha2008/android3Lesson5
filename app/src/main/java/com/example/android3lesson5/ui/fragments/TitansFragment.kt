package com.example.android3lesson5.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.android3lesson5.R
import com.example.android3lesson5.databinding.FragmentTitansBinding
import com.example.android3lesson5.ui.adapter.TitanAdapter
import com.example.android3lesson5.ui.viewmodel.TitanViewModel


class TitansFragment : Fragment() {

    private var _binding: FragmentTitansBinding? = null
    private val binding: FragmentTitansBinding get() = _binding!!
    private val viewModel: TitanViewModel by viewModels()
    private val titanAdapter = TitanAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTitansBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }

    private fun initialize() {
        binding.rvTitans.adapter = titanAdapter
    }

    private fun setupListener() {
        viewModel.titansState.observe(viewLifecycleOwner) { uistate ->
            uistate?.let {
                if (it.success != null) {
                    titanAdapter.submitList(it.success)
                    Log.e("success", "setupListener: ${it.success}", )
                } else {
                    Log.e("error", "данные не пришли${it.error}")
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}