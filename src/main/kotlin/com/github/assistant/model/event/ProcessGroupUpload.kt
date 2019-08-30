package com.github.assistant.model.event

import com.google.gson.annotations.SerializedName
import com.github.assistant.enum.TypeCode

class ProcessGroupUpload(@Transient override val typeCode: TypeCode = TypeCode.ProcessGroupUpload) : ICqApiEvent {
    @SerializedName("SubType")
    var subType: Int = 0
    @SerializedName("SendTime")
    var sendTime: Int = 0
    @SerializedName("FromGroup")
    var fromGroup: Long = 0
    @SerializedName("FromQQ")
    var fromQQ: Long = 0
    @SerializedName("File")
    var file: String? = null
}