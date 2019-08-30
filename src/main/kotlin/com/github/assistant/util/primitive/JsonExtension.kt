package com.github.assistant.util.primitive

import com.google.gson.Gson

fun <T> T.toJson(): String {
    return Gson().newBuilder().setPrettyPrinting().create().toJson(this)
}

inline fun <reified T> String.fromJson(): T {
    return Gson().fromJson(this, T::class.java)
}