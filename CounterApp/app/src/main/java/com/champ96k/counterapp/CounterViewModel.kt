package com.champ96k.counterapp
import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {

    private val _repository : CounterRepository = CounterRepository()

    private val _count =   mutableStateOf(_repository.getCounter().count)

    val count : Int get() = _count.value


    fun increment() {
        _repository.increment();
        _count.value = _repository.getCounter().count
    }

    fun decrement() {
        _repository.decrement()
        _count.value = _repository.getCounter().count
    }
}