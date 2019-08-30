package com.github.assistant.model.event

import com.google.gson.annotations.SerializedName
import com.github.assistant.enum.TypeCode

class ProcessGroupMemberDecrease(@Transient override val typeCode: TypeCode = TypeCode.ProcessGroupMemberDecrease) : ICqApiEvent {
    @SerializedName("SubType")
    var subType: Int = 0
    @SerializedName("SendTime")
    var sendTime: Int = 0
    @SerializedName("Target")
    var target: Long = 0
    @SerializedName("FromGroup")
    var fromGroup: Long = 0
    @SerializedName("FromQQ")
    var fromQQ: Long = 0
}