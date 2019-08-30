package com.github.assistant.util

class WebHeaderCollection : HashMap<String, String> {
    constructor(initialCapacity: Int, loadFactor: Float) : super(initialCapacity, loadFactor)
    constructor(initialCapacity: Int) : super(initialCapacity)
    constructor() : super()
    constructor(m: MutableMap<out String, out String>?) : super(m)

    constructor(vararg kvs: Pair<String, String>) {
        for ((k, v) in kvs) {
            put(k, v)
        }
    }
}