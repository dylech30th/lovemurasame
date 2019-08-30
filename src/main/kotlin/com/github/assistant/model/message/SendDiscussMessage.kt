package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param discussGroupNumber 讨论组号
 * @param message 消息内容
 */
class SendDiscussMessage(
    @SerializedName("讨论组号") val discussGroupNumber: Long,
    @SerializedName("msg") val message: String
) : IMahuaMessageBase {

    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_sendDiscussMsg"
}