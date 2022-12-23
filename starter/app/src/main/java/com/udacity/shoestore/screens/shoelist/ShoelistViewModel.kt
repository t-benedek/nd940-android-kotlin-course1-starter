package com.udacity.shoestore.screens.shoelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoelistViewModel: ViewModel() {

    private val mShoeList = mutableListOf<Shoe>()
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeListLive: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = mShoeList
        Log.i("ShoeListViewModel", "Init called")
    }

    fun addShoe(shoe: Shoe){
        for (i in 1..25) {
            mShoeList.add(shoe)
            _shoeList.value = mShoeList
            Log.i("ShoeListViewModel", "Shoe added " + shoe.name)
        }
    }
}

