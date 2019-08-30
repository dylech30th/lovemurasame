package com.github.assistant.model.event

import com.google.gson.annotations.SerializedName
import com.github.assistant.enum.TypeCode

class Initialize(@Transient override val typeCode: TypeCode = TypeCode.Initialize) : ICqApiEvent {
    @SerializedName("AuthCode")
    var authCode: String? = null
}