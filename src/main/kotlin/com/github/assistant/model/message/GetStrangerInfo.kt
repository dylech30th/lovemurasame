package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param qqNumber 目标QQ
 * @param doNotUseCache 不使用缓存
 */
class GetStrangerInfo(
    @SerializedName("qqid") val qqNumber: Long,
    @SerializedName("不使用缓存") val doNotUseCache: Boolean) : IMahuaMessageBase {

    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_getStrangerInfo"
}