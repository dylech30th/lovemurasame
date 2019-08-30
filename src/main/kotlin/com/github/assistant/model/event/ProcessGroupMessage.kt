package com.github.assistant.model.event

import com.google.gson.annotations.SerializedName
import com.github.assistant.enum.TypeCode

class ProcessGroupMessage(@Transient override val typeCode: TypeCode = TypeCode.ProcessGroupMessage) : ICqApiEvent {
    @SerializedName("Message")
    var message: String? = null
    @SerializedName("FromGroup")
    var fromGroup: Long = 0
    @SerializedName("FromAnonymous")
    var fromAnonymous: String? = null
    @SerializedName("FromQQ")
    var fromQQ: Long = 0
    @SerializedName("MsgId")
    var msgId: Int = 0
    @SerializedName("SubType")
    var subType: Int = 0
    @SerializedName("Font")
    var font: Int = 0
}