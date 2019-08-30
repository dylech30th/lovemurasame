package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param file 收到消息中的语音文件名
 * @param outFormat 应用所需的格式
 */
class GetRecord(
    val file: String,
    @SerializedName("outformat") val outFormat: String
) : IMahuaMessageBase {
    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_getRecord"
}