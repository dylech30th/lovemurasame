package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param exceptionMessage 错误信息
 */
class SetFatal(@SerializedName("错误信息") val exceptionMessage: String) : IMahuaMessageBase {

    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_setFatal"
}