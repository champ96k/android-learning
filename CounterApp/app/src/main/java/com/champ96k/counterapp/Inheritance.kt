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
}

class ThirdClass:SecondClass() {

}

class Offspring:SecondClass(),Archery,Singer  {

    override fun archery() {
        super.archery()
        println("Enhanced archery")
    }

    override fun sing() {
        super.sing()
        println("Enhanced sing")
    }

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

    val obj4 = Offspring()
    obj4.archery()
    obj4.sing()
    obj4.role(3)
    obj4.coreValue()
    obj4.myRole("John")

}