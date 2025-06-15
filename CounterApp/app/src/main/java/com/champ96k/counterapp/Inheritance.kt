package com.champ96k.counterapp

open class BaseClass {

   open fun role(number: Int) {
        println("This is base class role! - $number")
    }

    fun coreValue() {
        println("This is core value")
    }
}


open class SecondClass:BaseClass() {
     fun myRole(name:String) {
        println("This is second class role! $name")
    }

    override fun role(number: Int) {
        super.role(number)
        println("This is second class role! - $number")
    }
}

class ThirdClass:SecondClass() {

}

fun  main() {

    val obj1 = BaseClass()
    obj1.role(1)
    val obj2 = SecondClass()
    obj2.myRole("John")
    obj2.myRole("Alexa")
    obj2.role(12)

    val obj3 = ThirdClass();
    obj3.role(2);

}