package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param requestReplyIdentifier 请求事件收到的“反馈标识”参数
 * @param replyType #请求通过 或 #请求拒绝
 * @param note 添加后的好友备注
 */
class SetFriendAddRequest(
    @SerializedName("请求反馈标识") val requestReplyIdentifier: String,
    @SerializedName("反馈类型") val replyType: Int,
    @SerializedName("备注") val note: String
) : IMahuaMessageBase {

    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_setFriendAddRequest"
}