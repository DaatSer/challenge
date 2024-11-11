package com.example.crossmintchallenge.providers

internal interface NetworkConfigProvider {

    fun baseUrl(): String

    fun scheme(): String

}

internal class NetworkConfigProviderImpl : NetworkConfigProvider {

    override fun baseUrl(): String = "challenge.crossmint.io"

    override fun scheme(): String = "https"

}