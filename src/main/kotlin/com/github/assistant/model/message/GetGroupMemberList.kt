package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param groupNumber 目标QQ所在群
 */
class GetGroupMemberList(@SerializedName("群号") val groupNumber: Long) : IMahuaMessageBase {
    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_getGroupMemberList"
}