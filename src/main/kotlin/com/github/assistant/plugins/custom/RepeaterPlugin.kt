package com.github.assistant.plugins.custom

import com.github.assistant.enum.TypeCode
import com.github.assistant.model.event.ProcessGroupMessage
import com.github.assistant.model.message.SendGroupMessage
import com.github.assistant.plugins.adapter.ProcessGroupMessageEventPlugin
import com.github.assistant.util.primitive.fromJson

class RepeaterPlugin : ProcessGroupMessageEventPlugin() {
    override val typeCode: TypeCode = TypeCode.ProcessGroupMessage

    override fun handleMessage(message: String) {
        val instance = message.fromJson<ProcessGroupMessage>()
        if (instance.fromGroup == 909254513L) {
            SendGroupMessage(909254513L, instance.message!!).send()
        }
    }
}