package com.github.assistant.util.lang

fun <T> tripleExp(boolean: Boolean, result1: T, result2: T): T {
    return if (boolean) result1 else result2
}