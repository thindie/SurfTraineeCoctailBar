package com.example.thindie.surftrainee.data.localsource

import androidx.room.TypeConverter


class BaseListConverter(private val separator: String = SEPARATOR) {
    @TypeConverter
    fun toBase(from: List<String>): String {
        return from.joinToString(separator)
    }

    @TypeConverter
    fun fromBase(to: String): List<String> {
        return to.split(separator)
    }
}

private const val SEPARATOR = "######"