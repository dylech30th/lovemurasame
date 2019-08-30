package com.github.assistant.model.event

import com.google.gson.annotations.SerializedName
import com.github.assistant.enum.TypeCode

class ProcessAddFriendEventOutput(@Transient override val typeCode: TypeCode = TypeCode.ProcessAddFriendEventOutput) : ICqApiEvent {
    @SerializedName("SubType")
    var subType: Int = 0
    @SerializedName("SendTime")
    var sendTime: Int = 0
    @SerializedName("FromQQ")
    var fromQQ: Long = 0
    @SerializedName("Font")
    var font: Int = 0
    @SerializedName("Msg")
    var msg: String? = null
}