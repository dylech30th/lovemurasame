package com.github.assistant.model.event

import com.google.gson.annotations.SerializedName
import com.github.assistant.enum.TypeCode

class ProcessPrivateMessage(@Transient override val typeCode: TypeCode = TypeCode.ProcessPrivateMessage) : ICqApiEvent {
    @SerializedName("SubType")
    var subType: Int = 0
    @SerializedName("FromQQ")
    var fromQQ: Long = 0
    @SerializedName("Msg")
    var msg: String? = null
    @SerializedName("MsgId")
    var msgId: Int = 0
    @SerializedName("Font")
    var font: Int = 0
}