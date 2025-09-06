package omkar.android.projects.data.remote

import io.ktor.client.HttpClient

expect class HttpClientEngine() {
    fun create(): HttpClient
}