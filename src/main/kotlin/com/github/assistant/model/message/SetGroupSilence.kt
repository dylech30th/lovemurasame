package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param groupNumber 目标群
 * @param silence true/开启 false/关闭
 */
class SetGroupSilence(
    @SerializedName("群号") val groupNumber: Long,
    @SerializedName("开启禁言") val silence: Boolean
) : IMahuaMessageBase {

    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_setGroupWholeBan"
}