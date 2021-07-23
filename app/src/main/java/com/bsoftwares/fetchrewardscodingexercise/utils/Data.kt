package com.bsoftwares.fetchrewardscodingexercise.utils

import com.bsoftwares.fetchrewardscodingexercise.model.Data

fun dummyList() = listOf(
    Data(29, 1, "29"),
    Data(22, 2, "22"),
    Data(16, 2, "16"),
    Data(29, 3, "29"),
    Data(46, 3, "46"),
    Data(299, 1, "299"),
    Data(26, 3, "26"),
    Data(79, 3, "79"),
    Data(88, 1, "88"),
    Data(0, 2, "00"),
    Data(4, 3, "4")
)

fun correctDummyList() = listOf(
    Data(29, 1, "29"),
    Data(88, 1, "88"),
    Data(299, 1, "299"),
    Data(0, 2, "00"),
    Data(16, 2, "16"),
    Data(22, 2, "22"),
    Data(4, 3, "4"),
    Data(26, 3, "26"),
    Data(29, 3, "29"),
    Data(46, 3, "46"),
    Data(79, 3, "79")
)