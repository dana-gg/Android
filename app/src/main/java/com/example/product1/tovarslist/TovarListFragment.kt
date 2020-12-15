package com.example.product1.tovarslist;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.product1.R
import com.example.product1.tovardetails.TovarDetails


class TovarListFragment : Fragment() {

    private lateinit var viewModel: TovarListViewModel
    private  lateinit var viewModelFactory: TovarListViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view : View = inflater?.inflate(R.layout.fragment_tovar_list, container, false);

        viewModelFactory = TovarListViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TovarListViewModel::class.java)


        var contactsList:ListView =  view?.findViewById(R.id.tovarList);

        var adapter = ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_list_item_1, viewModel.tovar);

        contactsList.setAdapter(adapter);
        contactsList.setOnItemClickListener { parent, view, position, id ->
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.activity_main, TovarDetails())?.commit()
            //activity?.supportFragmentManager?.beginTransaction()?.remove(ContactsListFragment())?.commit()
         }

        return  view;
    }
}