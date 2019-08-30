package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param groupNumber 目标QQ所在群
 * @param qqNumber 目标QQ
 * @param doNotUseCache 不使用缓存
 */
class GetGroupMembersInfo(
    @SerializedName("群号") val groupNumber: Long,
    @SerializedName("qqid") val qqNumber: Long,
    @SerializedName("不使用缓存") val doNotUseCache: Boolean
) : IMahuaMessageBase {

    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_getGroupMemberInfoV2"
}