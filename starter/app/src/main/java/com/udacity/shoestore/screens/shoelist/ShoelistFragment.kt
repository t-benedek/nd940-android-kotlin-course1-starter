package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.databinding.FragmentShoelistBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ShoelistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoelistFragment : Fragment() {

    public lateinit var viewModel: ShoelistViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoelistBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoelist, container, false
        )

        binding.buttonLogout.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoelistFragment_to_loginFragment)
        )

        binding.buttonShoeDetails.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoelistFragment_to_shoeDetalsFragment)
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShoelistViewModel::class.java)
    }

//    fun getText(binding: FragmentShoelistBinding) {
//        val shoeName = binding.shoeNameEdit.text.toString()
//        val shoeSize = binding.shoeSizeEdit.text.toString()
//        val shoeCompany = binding.shoeCompanyEdit.text.toString()
//        val shoeDetail = binding.shoeDetailEdit.text.toString()
//        viewModel = ViewModelProvider(this).get(ShoesViewModel::class.java)
//        viewModel.addShoe(shoeName, shoeSize, shoeCompany, shoeDetail)
//        Log.i("shoes", viewModel.shoes.toString())
//    }
}