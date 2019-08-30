package com.github.assistant.util.reflection

import java.lang.reflect.Constructor
import java.lang.reflect.Modifier

object ReflectionHelper {
    private class Caller : SecurityManager() {
        companion object {
            val INSTANCE = Caller()
        }

        fun getCallingClasses(): Array<Class<*>> {
            return classContext
        }
    }

    fun callerClass(): Class<*> {
        return Caller.INSTANCE.getCallingClasses().run {
            this[this.size - 2]
        }
    }

    fun existedClass(): Class<*> {
        return Caller.INSTANCE.getCallingClasses().run {
            this[size - 3]
        }
    }

    fun isFieldlessClass(clazz: Class<*>): Boolean {
        return clazz.declaredFields.isEmpty()
    }

    fun constructors(clazz: Class<*>): List<Constructor<*>> {
        return clazz.constructors.toList()
    }

    fun hadNonParameterConstructor(clazz: Class<*>): Boolean {
        return constructors(clazz).any { it.parameterCount == 0 }
    }

    fun nonParameterConstructor(clazz: Class<*>): Constructor<*> {
        if (hadNonParameterConstructor(clazz)) {
            return constructors(clazz).first { it.parameterCount == 0 }
        }
        throw NoSuchMethodException("class provided does not contains constructor with 0 parameter")
    }

    fun notClass(clazz: Class<*>): Boolean {
        return Modifier.isAbstract(clazz.modifiers) || Modifier.isInterface(clazz.modifiers)
    }
}

inline fun <reified T> genericType(): Class<T> {
    return T::class.java
}