package com.github.assistant.model.message

class GetLoginNickname : IMahuaMessageBase {
    @Transient
    override val requestUrl: String = "http://127.0.0.1:36524/api/v1/Cqp/CQ_getLoginNick"
}