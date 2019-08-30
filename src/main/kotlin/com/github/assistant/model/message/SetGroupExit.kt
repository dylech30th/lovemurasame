package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param groupNumber 目标群
 * @param dismiss true/解散本群(群主) false/退出本群(管理、群成员)
 */
class SetGroupExit(
    @SerializedName("群号") val groupNumber: Long,
    @SerializedName("是否解散") val dismiss: Boolean
) : IMahuaMessageBase {

    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_setGroupLeave"
}