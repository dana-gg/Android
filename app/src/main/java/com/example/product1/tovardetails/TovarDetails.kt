package com.example.product1.tovardetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.product1.R
import com.example.product1.databinding.FragmentTovarDetailsBinding


class TovarDetails: Fragment() {
    private lateinit var binding: FragmentTovarDetailsBinding
    private lateinit var viewModel: TovarDetailsViewModel
    private lateinit var viewModelFactory: TovarDetailsViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_tovar_details,
                container,
                false
        )

        viewModelFactory = TovarDetailsViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TovarDetailsViewModel::class.java)

        binding.tovarDetailsViewModel = viewModel
        binding.setLifecycleOwner(this)

        return  binding.root
    }
}