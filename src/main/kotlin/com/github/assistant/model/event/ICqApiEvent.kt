package com.github.assistant.model.event

import com.github.assistant.enum.TypeCode
import com.github.assistant.plugins.Plugins
import com.github.assistant.util.runAsync

interface ICqApiEvent {
    val typeCode: TypeCode

    fun callHandler(message: String, clazz: TypeCode) {
        val plugins = Plugins.getPlugins(clazz) ?: return

        for (plugin in plugins) {
            runAsync {
                plugin.handleMessage(message)
            }
        }
    }
}