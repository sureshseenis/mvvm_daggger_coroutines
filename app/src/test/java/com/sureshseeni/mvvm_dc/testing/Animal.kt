package com.sureshseeni.mvvm_dc.testing

import org.junit.Test


//Test abstract class
abstract class Animal {
    abstract fun playSound()

    fun sleep(){
        print("ZZZ")
    }

}
class DogClass : Animal(){
    override fun playSound() {
        println("Wov")
    }
}
class Animals{
   @Test
   fun testSound(){
       var dogClass=DogClass()
       dogClass.playSound()
       dogClass.sleep()
   }
}