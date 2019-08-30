package com.github.assistant.server

import com.github.assistant.exception.UnsupportedRequestException
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.client.HttpRequest
import com.github.assistant.util.WebHeaderCollection
import org.apache.http.client.fluent.Request
import org.apache.http.entity.StringEntity
import java.nio.charset.StandardCharsets

data class HttpContext(val uri: String, val headers: WebHeaderCollection = WebHeaderCollection(), val method: HttpMethod = HttpMethod.GET, val external: String = "", val connectionTimeOut: Int = 5000)

object HttpClient {
    private fun HttpRequest<*>.headers(headers: WebHeaderCollection): HttpRequest<*> {
        return this.apply {
            headers.forEach { (k, v) -> this.putHeader(k, v) }
        }
    }

    fun request(context: HttpContext): String {
        return when(context.method) {
            HttpMethod.GET -> get(context)
            HttpMethod.POST -> post(context)
            else -> throw UnsupportedRequestException()
        }
    }

    private fun post(context: HttpContext): String {
        return Request.Post(context.uri)
            .headers(context.headers)
            .body(StringEntity(context.external, StandardCharsets.UTF_8))
            .connectTimeout(context.connectionTimeOut)
            .socketTimeout(context.connectionTimeOut)
            .execute()
            .returnContent()
            .asString(StandardCharsets.UTF_8)
    }

    private fun get(context: HttpContext): String {
        return Request.Get(context.uri)
            .headers(context.headers)
            .connectTimeout(context.connectionTimeOut)
            .socketTimeout(context.connectionTimeOut)
            .execute()
            .returnContent()
            .asString(StandardCharsets.UTF_8)
    }

    private fun Request.headers(headers: WebHeaderCollection): Request {
        for ((k, v) in headers) {
            this.addHeader(k, v)
        }
        return this
    }
}
