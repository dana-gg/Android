package com.example.product1.addtovar;

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.product1.R
import com.example.product1.databinding.FragmentAddTovarBinding
import timber.log.Timber


class AddTovarFragment : Fragment() {

    private lateinit var binding: FragmentAddTovarBinding
    private lateinit var viewModel: AddTovarViewModel
    private lateinit var viewModelFactory: AddTovarViewModelFactory

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

            binding = DataBindingUtil.inflate(
                    inflater,
                    R.layout.fragment_add_tovar,
                    container,
                    false
            )

            Timber.i("Called ViewModelProviders.of!");

            viewModelFactory = AddTovarViewModelFactory()
            viewModel = ViewModelProviders.of(this, viewModelFactory).get(AddTovarViewModel::class.java)

            binding.addTovarViewModel = viewModel
            binding.setLifecycleOwner(this)

        return binding.root;
    }
}