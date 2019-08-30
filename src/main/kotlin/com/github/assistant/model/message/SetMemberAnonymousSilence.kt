package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param groupNumber 目标群
 * @param anonymousName 群消息事件收到的“匿名”参数
 * @param timeSpan 禁言的时间，单位为秒。不支持解禁
 */
class SetMemberAnonymousSilence(
    @SerializedName("群号") val groupNumber: Long,
    @SerializedName("匿名") val anonymousName: String,
    @SerializedName("禁言时间") val timeSpan: Long
) : IMahuaMessageBase {
    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_setGroupAnonymousBan"
}