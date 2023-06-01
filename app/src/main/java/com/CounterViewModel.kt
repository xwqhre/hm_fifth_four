package com

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {

    var count = 0
    val state = MutableLiveData<String>()

    fun increment(){
        count++
        state.value = count.toString()
    }

    fun decrement(){
        count--
        state.value = count.toString()
    }
}