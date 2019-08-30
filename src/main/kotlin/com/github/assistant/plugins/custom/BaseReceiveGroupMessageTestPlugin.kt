package com.github.assistant.plugins.custom

import com.github.assistant.enum.TypeCode
import com.github.assistant.model.event.ProcessGroupMessage
import com.github.assistant.plugins.adapter.ProcessGroupMessageEventPlugin
import com.github.assistant.util.annotation.DeprecatedPlugin
import com.github.assistant.util.primitive.fromJson

@DeprecatedPlugin
class BaseReceiveGroupMessageTestPlugin : ProcessGroupMessageEventPlugin() {
    override val typeCode: TypeCode = TypeCode.ProcessGroupMessage

    override fun handleMessage(message: String) {
        val json = message.fromJson<ProcessGroupMessage>()
        println("从群${json.fromGroup}发来的消息: ${json.message}")
    }

}