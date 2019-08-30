package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param groupNumber 目标群
 * @param qqNumber 被设置的QQ
 * @param newNickname 昵称
 */
class SetMemberCard(
    @SerializedName("群号") val groupNumber: Long,
    @SerializedName("qqid") val qqNumber: Long,
    @SerializedName("新名片_昵称") val newNickname: String
) : IMahuaMessageBase {
    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_setGroupCard"
}