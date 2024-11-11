package com.example.crossmintchallenge.providers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class NetworkConfigProviderImplTest {

    private lateinit var provider: NetworkConfigProvider

    @BeforeEach
    fun setup() {
        provider = NetworkConfigProviderImpl()
    }

    @Test
    fun `GIVEN https scheme WHEN scheme THEM equals`() {
        val expected = "https"
        val actual = provider.scheme()

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN crossmint http WHEN baseUrl THEM equals`() {
        val expected = "challenge.crossmint.io"
        val actual = provider.baseUrl()

        assertEquals(expected, actual)
    }

}