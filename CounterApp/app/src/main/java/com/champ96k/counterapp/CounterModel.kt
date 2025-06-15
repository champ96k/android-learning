package com.champ96k.counterapp

data class CounterModel(var count: Int)

class CounterRepository {

    private var _counter = CounterModel(count = 0)
    fun getCounter() = _counter

    fun increment() {
        _counter.count++
    }

    fun decrement() {
        _counter.count--
    }
}