package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param groupNumber 目标群
 * @param qqNumber 目标QQ
 * @param timeSpan 禁言时长，单位秒，解禁填0
 */
class SetMemberSilence(
    @SerializedName("群号") val groupNumber: Long,
    @SerializedName("qqid") val qqNumber: Long,
    @SerializedName("禁言时间") val timeSpan: Long
) : IMahuaMessageBase {
    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_setGroupBan"
}