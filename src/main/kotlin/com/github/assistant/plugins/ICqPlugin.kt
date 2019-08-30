package com.github.assistant.plugins

import com.github.assistant.enum.TypeCode

interface ICqPlugin  {
    val typeCode: TypeCode
    fun handleMessage(message: String)
    fun load()
    fun unload()
}