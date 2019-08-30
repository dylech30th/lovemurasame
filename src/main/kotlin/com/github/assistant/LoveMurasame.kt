package com.github.assistant

import com.github.assistant.plugins.Plugins
import com.github.assistant.server.MahuaServer

fun main() {
    Plugins.injectPlugins()
    MahuaServer.startListen()
}