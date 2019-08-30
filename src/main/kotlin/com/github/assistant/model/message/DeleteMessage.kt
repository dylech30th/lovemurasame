package com.github.assistant.model.message

import com.google.gson.annotations.SerializedName

/**
 * @param messageId 消息id
 */
class DeleteMessage(@SerializedName("msgId") val messageId: Long) : IMahuaMessageBase {
    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_deleteMsg"
}