package com.champ96k.counterapp
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {

    private val _count =   mutableStateOf(0)

    val count : Int get() = _count.value

    val  count1 : MutableState<Int> = _count

    fun increment() {
        _count.value += 1
    }

    fun decrement() {
        _count.value -= 1
    }
}