package com.github.assistant.util

import java.util.concurrent.CompletableFuture

fun <T> supplyAsync(block: () -> T): CompletableFuture<T> = CompletableFuture.supplyAsync(block)

fun runAsync(block: () -> Unit): CompletableFuture<Void> = CompletableFuture.runAsync(block)