package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param groupNumber 目标群
 * @param qqNumber 目标QQ
 * @param refuseRequest 拒绝接受此人请求
 */
class SetMemberKick(
    @SerializedName("群号") val groupNumber: Long,
    @SerializedName("qqid") val qqNumber: Long,
    @SerializedName("拒绝再加群") val refuseRequest: Boolean
) : IMahuaMessageBase {
    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_setGroupKick"
}