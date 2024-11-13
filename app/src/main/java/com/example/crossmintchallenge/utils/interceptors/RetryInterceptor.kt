package com.example.crossmintchallenge.utils.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

internal class RetryInterceptor(
    private val maxRetries: Int = MAX_RETRIES,
    private val delay: Long = DELAY,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var attempt = 0
        var response: Response?
        var exception: IOException? = null

        while (attempt < maxRetries) {
            try {
                response = chain.proceed(chain.request())

                if (response.isSuccessful) {
                    return response
                } else {
                    response.close()
                }
            } catch (e: IOException) {
                exception = e
            }

            attempt++
            Thread.sleep(delay)
        }

        throw exception ?: IOException("Request failed after $maxRetries attempts")
    }

    private companion object {

        const val MAX_RETRIES = 5
        const val DELAY = 1000L

    }
}
