package com.github.assistant.util.collection

fun <K, V> Map<K, V>.effectivePair(key: K): Boolean {
    return this.containsKey(key) && this[key] != null
}

fun <K, V> Map<K, V>.emptyValue(key: K): Boolean {
    return this.contains(key) && this[key] == null
}

fun <T> MutableIterable<T>.removeAndReturn(predicate: (T) -> Boolean): MutableIterable<T> {
    this.removeAll(predicate)
    return this
}

infix fun <T> Iterable<T>.except(another: Iterable<T>): List<T> {
    val intersect = this intersect another
    val union = intersect union another
    return union.toMutableList().apply { removeAll(intersect) }
}