package com.example.thindie.surftrainee.data

import com.example.thindie.surftrainee.data.localsource.CocktailDbModel
import com.example.thindie.surftrainee.domain.Cocktail

fun CocktailDbModel.toCocktail(): Cocktail {
    return Cocktail(
        name = name,
        recipe = recipe,
        description = description,
        cocktailParts = cocktailParts,
        isHasPhoto = isHasPhoto,
        photoPath = photoPath
    )
}

fun Cocktail.toCocktailDbModel(): CocktailDbModel {
    return CocktailDbModel(
        name = name,
        recipe = recipe,
        description = description,
        cocktailParts = cocktailParts,
        isHasPhoto = isHasPhoto,
        photoPath = photoPath
    )
}