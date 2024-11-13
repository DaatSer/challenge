package com.example.crossmintchallenge.utils

fun <T : Enum<T>> Enum<T>.enumToString(mapping: Map<String, T>): String =
    mapping.entries.find { entry -> entry.value == this }?.key
        ?: throw IllegalArgumentException("can't find key $this, in mapping $mapping")