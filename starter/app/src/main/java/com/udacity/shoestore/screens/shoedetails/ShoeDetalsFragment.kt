package com.udacity.shoestore.screens.shoedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetalsBinding
import com.udacity.shoestore.databinding.FragmentShoelistBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetalsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetalsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetalsBinding= DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detals, container, false
        )

        binding.buttonSave.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetalsFragment_to_shoelistFragment)
        )

        binding.buttonCancel.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetalsFragment_to_shoelistFragment)
        )

        return binding.root
    }
}