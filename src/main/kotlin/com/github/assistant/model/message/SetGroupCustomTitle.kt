package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param groupNumber 目标群
 * @param qqNumber 目标QQ
 * @param title 头衔, 如果要删除，这里填空
 * @param expiredTime 专属头衔有效期，单位为秒。如果永久有效，这里填写-1
 */
class SetGroupCustomTitle(
    @SerializedName("群号") val groupNumber: Long,
    @SerializedName("qqid") val qqNumber: Long,
    @SerializedName("头衔") val title: String,
    @SerializedName("过期时间") val expiredTime: Long
) : IMahuaMessageBase {
    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_setGroupSpecialTitle"
}