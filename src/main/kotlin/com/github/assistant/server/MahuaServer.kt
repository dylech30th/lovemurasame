package com.github.assistant.server

import com.github.assistant.enum.TypeCode
import com.github.assistant.exception.UnknownTypeCodeException
import com.github.assistant.model.event.*
import io.vertx.ext.web.RoutingContext
import com.github.assistant.util.primitive.fromJson
import com.google.gson.annotations.SerializedName
import io.vertx.core.Vertx
import io.vertx.core.VertxOptions
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router
import java.nio.charset.StandardCharsets

object MahuaServer {
    fun startListen() {
        val vertX = Vertx.vertx(VertxOptions().setWorkerPoolSize(10))
        val server = vertX.createHttpServer()
        val router = Router.router(vertX)

        router.route("/api/ReceiveMahuaOutput").method(HttpMethod.POST).handler {
            processReceive(it)
        }

        server.requestHandler(router).listen(65321)
    }

    private fun processReceive(context: RoutingContext) {
        context.request().bodyHandler {
            it.toString(StandardCharsets.UTF_8).apply {
                when (TypeCode.parse(this.fromJson<DeserializeIdentifier>().typeCode ?: throw UnknownTypeCodeException())) {
                    TypeCode.ProcessGroupMessage -> this.fromJson<ProcessGroupMessage>().callHandler(this, TypeCode.ProcessGroupMessage)
                    TypeCode.ProcessJoinGroupEventOutput -> this.fromJson<ProcessJoinGroupEventOutput>().callHandler(this, TypeCode.ProcessJoinGroupEventOutput)
                    TypeCode.CoolQExited -> this.fromJson<CoolQExited>().callHandler(this, TypeCode.CoolQExited)
                    TypeCode.Disabled -> this.fromJson<Disabled>().callHandler(this, TypeCode.Disabled)
                    TypeCode.Enabled -> this.fromJson<Enabled>().callHandler(this, TypeCode.Enabled)
                    TypeCode.Initialize -> this.fromJson<Initialize>().callHandler(this, TypeCode.Initialize)
                    TypeCode.ProcessAddFriendEventOutput -> this.fromJson<ProcessAddFriendEventOutput>().callHandler(this, TypeCode.ProcessAddFriendEventOutput)
                    TypeCode.ProcessDiscussGroupMessage -> this.fromJson<ProcessDiscussGroupMessage>().callHandler(this, TypeCode.ProcessDiscussGroupMessage)
                    TypeCode.ProcessFriendsAdded -> this.fromJson<ProcessFriendsAdded>().callHandler(this, TypeCode.ProcessFriendsAdded)
                    TypeCode.ProcessGroupAdminChange -> this.fromJson<ProcessGroupAdminChange>().callHandler(this, TypeCode.ProcessGroupAdminChange)
                    TypeCode.ProcessGroupMemberDecrease -> this.fromJson<ProcessGroupMemberDecrease>().callHandler(this, TypeCode.ProcessGroupMemberDecrease)
                    TypeCode.ProcessGroupMemberIncrease -> this.fromJson<ProcessGroupMemberIncrease>().callHandler(this, TypeCode.ProcessGroupMemberIncrease)
                    TypeCode.ProcessGroupUpload -> this.fromJson<ProcessGroupUpload>().callHandler(this, TypeCode.ProcessGroupUpload)
                    TypeCode.ProcessPrivateMessage -> this.fromJson<ProcessPrivateMessage>().callHandler(this, TypeCode.ProcessPrivateMessage)
                    null -> { /* 机器人本身发送消息的信息，暂时用不上所以不写 */ }
                }
            }
        }
    }

    private class DeserializeIdentifier {
        @SerializedName("TypeCode")
        var typeCode: String? = null
    }
}