package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param groupNumber 目标群
 * @param qqNumber 被设置的qq
 * @param asAdmin true/设置管理员 false/取消管理员
 */
class SetGroupAdmin(
    @SerializedName("群号") val groupNumber: Long,
    @SerializedName("qqid") val qqNumber: Long,
    @SerializedName("成为管理员") val asAdmin: Boolean
) : IMahuaMessageBase {
    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_setGroupAdmin"
}