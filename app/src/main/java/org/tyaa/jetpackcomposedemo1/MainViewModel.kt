package org.tyaa.jetpackcomposedemo1

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel(){
    val randomNumbersModel = RandomNumbersModel(arrayListOf())
    fun getRandomNumbers(){
        val result = arrayListOf<String>()
        for (i in 0..20){
            result.add(Random.nextInt(0, 999999).toString())
        }
        randomNumbersModel.list = result
    }
}