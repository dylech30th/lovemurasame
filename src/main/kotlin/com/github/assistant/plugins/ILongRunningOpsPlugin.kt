package com.github.assistant.plugins

interface ILongRunningOpsPlugin : ICqPlugin {
    val enabled: Boolean
    fun sendEnableOnMessage(message: String)
    fun sendDisableOnMessage(message: String)
}