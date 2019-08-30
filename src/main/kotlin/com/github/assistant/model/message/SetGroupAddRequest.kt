package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param requestReplyIdentifier 请求事件收到的“反馈标识”参数
 * @param requestType 根据请求事件的子类型区分 #请求群添加 或 #请求群邀请
 * @param replyType #请求通过 或 #请求拒绝
 * @param reason 操作理由，仅 #请求群添加 且 #请求拒绝 时可用
 */
class SetGroupAddRequest(
    @SerializedName("请求反馈标识") val requestReplyIdentifier: String,
    @SerializedName("反馈类型") val replyType: Int,
    @SerializedName("请求类型") val requestType: Int,
    @SerializedName("理由") val reason: String
) : IMahuaMessageBase {

    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_setGroupAddRequestV2"
}