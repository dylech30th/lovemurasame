package com.github.assistant.util.reflection

object AnnotationHelper {
    fun getClassAnnotation(clazz: Class<*>): List<Annotation> {
        return clazz.declaredAnnotations.toList()
    }

    fun containsAnnotation(clazz: Class<*>, annotationClass: Class<Annotation>): Boolean {
        return getClassAnnotation(clazz).any { it::class.java == annotationClass }
    }
}