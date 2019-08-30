package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param discussGroupNumber 目标讨论组
 */
class SetDiscussExit(@SerializedName("讨论组号") val discussGroupNumber: Long) : IMahuaMessageBase {

    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_sendDiscussMsg"
}