package com.github.assistant.model.message

import io.vertx.core.http.HttpMethod
import com.github.assistant.server.HttpClient.request
import com.github.assistant.server.HttpContext
import com.github.assistant.util.WebHeaderCollection
import com.github.assistant.util.primitive.toJson

interface IMahuaMessageBase {
    val requestUrl: String

    fun jsonify(): String {
        return this.toJson()
    }

    fun send(): String {
        return request(
            HttpContext(
                requestUrl,
                WebHeaderCollection("Content-Type" to "application/json"),
                HttpMethod.POST,
                jsonify(),
                1000
            )
        )
    }
}