package com.github.assistant.plugins.custom

import com.github.assistant.enum.TypeCode
import com.github.assistant.plugins.adapter.ProcessPrivateMessageEventPlugin

class BaseTestPlugin : ProcessPrivateMessageEventPlugin() {
    override val typeCode: TypeCode = TypeCode.ProcessPrivateMessage

    override fun handleMessage(message: String) {
        println("message received$message")
    }

    override fun load() {
        super.load()
    }

    override fun unload() {
        super.unload()
    }
}