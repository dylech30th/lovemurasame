package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param groupNumber 群号
 * @param message 消息内容
 */
class SendGroupMessage(
    @SerializedName("群号") val groupNumber: Long,
    @SerializedName("msg") val message: String
) : IMahuaMessageBase {
    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_sendGroupMsg"
}