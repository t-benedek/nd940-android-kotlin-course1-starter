package com.udacity.shoestore.screens.shoedetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetalsBinding
import com.udacity.shoestore.screens.shoelist.Shoe
import com.udacity.shoestore.screens.shoelist.ShoelistViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetalsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailsFragment : Fragment() {

    private val shoe:Shoe = Shoe("Air", "42", "Nike", "Air Jordan")

    private val viewModel:ShoelistViewModel by activityViewModels<ShoelistViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentShoeDetalsBinding= DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detals, container, false
        )
        binding.shoe = shoe

        binding.buttonSave.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val name:String = binding.shoeNameEdit.text.toString()
                Log.i("ShoeDetails", "Adding Shoe with name " + name)
                val size:String = binding.shoeSizeEdit.text.toString()
                val company:String = binding.shoeCompanyEdit.text.toString()
                val desc:String = binding.shoeDescEdit.text.toString()
                val shoe:Shoe = Shoe(name, size, company, desc)
                viewModel.addShoe(shoe)

                if (view != null) {
                    Navigation.findNavController(view).navigate(R.id.action_shoeDetalsFragment_to_shoelistFragment)
                }
            }
        })

        binding.buttonCancel.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetalsFragment_to_shoelistFragment)
        )

        return binding.root
    }

}