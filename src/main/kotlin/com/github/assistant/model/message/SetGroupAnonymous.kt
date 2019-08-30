package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param groupNumber 目标群
 * @param anonymous 开启匿名
 */
class SetGroupAnonymous(
    @SerializedName("群号") val groupNumber: Long,
    @SerializedName("开启匿名") val anonymous: Boolean
) : IMahuaMessageBase {

    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_setGroupAnonymous"
}