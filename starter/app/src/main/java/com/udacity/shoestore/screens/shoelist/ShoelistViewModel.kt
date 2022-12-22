package com.udacity.shoestore.screens.shoelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoelistViewModel: ViewModel() {

    private var _shoeList = MutableLiveData<List<Shoe>>()
    val shoeListLive: LiveData<List<Shoe>>
        get() = _shoeList

    private val mShoeList = mutableListOf<Shoe>()

    init {
        _shoeList.value = mShoeList
        Log.i("ShoeListViewModel", "Init called")
    }

    fun addShoe(shoe: Shoe){
        mShoeList.add(shoe)
        Log.i("ShoeListViewModel", "Shoe added " + shoe.name)
    }
}

