package com.bsoftwares.fetchrewardscodingexercise.utils

import android.graphics.Color
import com.bsoftwares.fetchrewardscodingexercise.model.Data
import kotlin.random.Random

fun createDifferentColorForEachListId(list : List<Data>) : MutableList<Int> {
    val listOfColors = mutableListOf<Int>()
    for (eachId in list.distinctBy { it.listId }){
        listOfColors.add(getRandomColor())
    }
    return listOfColors
}

fun getRandomColor() = Color.argb(255,Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))