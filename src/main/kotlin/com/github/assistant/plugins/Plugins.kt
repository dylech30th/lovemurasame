package com.github.assistant.plugins

import com.github.assistant.enum.TypeCode
import com.github.assistant.exception.UnloadPluginFailedException
import com.github.assistant.util.annotation.DeprecatedPlugin
import com.github.assistant.util.annotation.IdlePlugin
import com.github.assistant.util.annotation.TestPlugin
import org.reflections.Reflections
import com.github.assistant.util.collection.effectivePair
import com.github.assistant.util.reflection.ReflectionHelper

object Plugins {
    private val receiveEventHandlers: MutableMap<TypeCode, MutableSet<ICqPlugin>>
            by lazy { hashMapOf<TypeCode, MutableSet<ICqPlugin>>() }

    private fun <R : ICqPlugin> registerReceiveEventPlugin(clazz: TypeCode, plugin: R) {
        ensureKeyExist(clazz)
        plugin.load()
        receiveEventHandlers[clazz]!!.add(plugin)
    }

    internal fun <R : ICqPlugin> unregisterReceiveEventPlugin(clazz: TypeCode, plugin: Class<R>) {
        ensureKeyExist(clazz)
        receiveEventHandlers[clazz]!!.removeIf {
            val clz = it::class.java
            if (clz.name == plugin.name) {
                it.unload()
                return@removeIf true
            }
            return@removeIf false
        }
        ensurePluginRemoved(clazz, plugin.name)
    }

    internal fun injectPlugins() {
        val plugins = scanPlugins()
        for (pluginCls in plugins) {
            val instance = ReflectionHelper.nonParameterConstructor(pluginCls).newInstance() as ICqPlugin
            when (instance.typeCode) {
                TypeCode.CoolQExited -> registerReceiveEventPlugin(TypeCode.CoolQExited, instance)
                TypeCode.Disabled -> registerReceiveEventPlugin(TypeCode.Disabled, instance)
                TypeCode.Enabled -> registerReceiveEventPlugin(TypeCode.Enabled, instance)
                TypeCode.Initialize -> registerReceiveEventPlugin(TypeCode.Initialize, instance)
                TypeCode.ProcessAddFriendEventOutput -> registerReceiveEventPlugin(TypeCode.ProcessAddFriendEventOutput, instance)
                TypeCode.ProcessDiscussGroupMessage -> registerReceiveEventPlugin(TypeCode.ProcessDiscussGroupMessage, instance)
                TypeCode.ProcessFriendsAdded -> registerReceiveEventPlugin(TypeCode.ProcessFriendsAdded, instance)
                TypeCode.ProcessGroupAdminChange -> registerReceiveEventPlugin(TypeCode.ProcessGroupAdminChange, instance)
                TypeCode.ProcessGroupMemberDecrease -> registerReceiveEventPlugin(TypeCode.ProcessGroupMemberDecrease, instance)
                TypeCode.ProcessGroupMemberIncrease -> registerReceiveEventPlugin(TypeCode.ProcessGroupMemberIncrease, instance)
                TypeCode.ProcessGroupMessage -> registerReceiveEventPlugin(TypeCode.ProcessGroupMessage, instance)
                TypeCode.ProcessGroupUpload -> registerReceiveEventPlugin(TypeCode.ProcessGroupUpload, instance)
                TypeCode.ProcessJoinGroupEventOutput -> registerReceiveEventPlugin(TypeCode.ProcessJoinGroupEventOutput, instance)
                TypeCode.ProcessPrivateMessage -> registerReceiveEventPlugin(TypeCode.ProcessPrivateMessage, instance)
            }
        }
    }

    internal fun availablePlugins(): List<MutableSet<ICqPlugin>> {
        return receiveEventHandlers.values.toList()
    }

    internal fun getPlugins(clazz: TypeCode): MutableSet<ICqPlugin>? {
        return receiveEventHandlers[clazz]
    }

    private fun ensureKeyExist(clazz: TypeCode) {
        if (!receiveEventHandlers.effectivePair(clazz)) {
            receiveEventHandlers[clazz] = mutableSetOf()
        }
    }

    private fun scanPlugins(): List<Class<out Any>> {
        val reflections = Reflections("com.github.assistant.plugins.custom")
        val annotated = reflections.getTypesAnnotatedWith(TestPlugin::class.java) +
                reflections.getTypesAnnotatedWith(DeprecatedPlugin::class.java) +
                reflections.getTypesAnnotatedWith(IdlePlugin::class.java)

        return reflections.getSubTypesOf(ICqPlugin::class.java)
            .filter { !annotated.contains(it) && !ReflectionHelper.notClass(it) && ReflectionHelper.hadNonParameterConstructor(it) }
    }

    private fun ensurePluginRemoved(clazz: TypeCode, plugin: String) {
        if (receiveEventHandlers.containsKey(clazz) && receiveEventHandlers[clazz]!!.any { it::class.java.name == plugin }) {
            throw UnloadPluginFailedException()
        }
    }
}