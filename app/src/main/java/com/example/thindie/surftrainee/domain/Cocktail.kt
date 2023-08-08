package com.example.thindie.surftrainee.domain

data class Cocktail(
    val name: String,
    val isHasPhoto: Boolean,
    val photoPath: String = ""
)