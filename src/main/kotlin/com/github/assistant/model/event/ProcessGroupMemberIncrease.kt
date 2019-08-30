package com.github.assistant.model.event

import com.google.gson.annotations.SerializedName
import com.github.assistant.enum.TypeCode

class ProcessGroupMemberIncrease(@Transient override val typeCode: TypeCode = TypeCode.ProcessGroupMemberIncrease) : ICqApiEvent {
    @SerializedName("SubType")
    var subType: Int = 0
    @SerializedName("SendTime")
    var sendTime: Int = 0
    @SerializedName("Target")
    var target: Int = 0
    @SerializedName("FromGroup")
    var fromGroup: Int = 0
    @SerializedName("FromQQ")
    var fromQQ: Int = 0
}