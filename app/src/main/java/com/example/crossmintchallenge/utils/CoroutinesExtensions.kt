package com.example.crossmintchallenge.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend inline fun <T> onIo(noinline block: suspend CoroutineScope.() -> T) = withContext(Dispatchers.IO, block)