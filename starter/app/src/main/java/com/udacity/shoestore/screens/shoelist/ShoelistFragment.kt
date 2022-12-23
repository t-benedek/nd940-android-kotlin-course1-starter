package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoelistBinding
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.databinding.ShoeLayoutBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ShoelistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoelistFragment : Fragment() {

    private val viewModel:ShoelistViewModel by activityViewModels<ShoelistViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val shoeListBinding: FragmentShoelistBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoelist, container, false
        )

        shoeListBinding.buttonLogout.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_shoelistFragment_to_loginFragment)
        )

        shoeListBinding.buttonShoeDetails.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_shoelistFragment_to_shoeDetalsFragment)
        )

        viewModel.shoeListLive.observe(viewLifecycleOwner, androidx.lifecycle.Observer { shoeList ->
            for (shoe in shoeList) {
                Log.i("ShowListFragment", "ViewModel Observer called")

                val shoeItembinding: ShoeLayoutBinding = DataBindingUtil.inflate(
                    inflater, R.layout.shoe_layout, container, false
                )

                shoeItembinding.shoe = shoe
                shoeListBinding.layoutShoelist.addView(shoeItembinding.root)
            }
        })

        return shoeListBinding.root
    }
}