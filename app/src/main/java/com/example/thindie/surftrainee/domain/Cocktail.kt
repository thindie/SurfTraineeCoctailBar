package com.example.thindie.surftrainee.domain

data class Cocktail(
    val name: String,
    val recipe: String = OPTIONAL,
    val description: String = OPTIONAL,
    val cocktailParts: List<String>,
    val isHasPhoto: Boolean,
    val photoPath: String = OPTIONAL
)

private const val OPTIONAL = ""