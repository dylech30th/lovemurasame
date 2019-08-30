package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param qqNumber 目标QQ
 * @param message 消息内容
 */
class SendPrivateMessage(
    @SerializedName("群号") val qqNumber: Long,
    @SerializedName("msg") val message: String
) : IMahuaMessageBase {

    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_sendPrivateMsg"
}