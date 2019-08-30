package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param priority 优先级
 * @param type 类型
 * @param content 内容
 */
class AddLog(
    @SerializedName("优先级") /*  */ val priority: Int,
    @SerializedName("类型") val type: String,
    @SerializedName("内容") val content: String
) : IMahuaMessageBase {

    @Transient
    override val requestUrl = "http://127.0.0.1:36524/api/v1/Cqp/CQ_addLog"
}