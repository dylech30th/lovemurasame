package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param qqNumber 目标QQ
 * @param times 赞的次数，最多10次
 */
class SendLike(
    @SerializedName("qqid") val qqNumber: Long,
    val times: Int
) : IMahuaMessageBase {

    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_sendLikeV2"
}