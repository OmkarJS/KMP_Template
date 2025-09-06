package omkar.android.projects.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import omkar.android.projects.app.constants.Constants
import omkar.android.projects.data.model.ExampleRequest
import omkar.android.projects.data.model.ExampleResponse
import omkar.android.projects.data.remote.util.ApiResponseWrapper
import omkar.android.projects.data.remote.util.handleApiCall

class ExampleClient(
    private val httpClient: HttpClient
) {
    suspend fun fetchExample(): ApiResponseWrapper<ExampleResponse> {
        return handleApiCall {
            httpClient.post(Constants.Spiker.FETCH_TRANSCRIPT_END_POINT) {
                contentType(ContentType.Application.Json)
                setBody(ExampleRequest())
            }.body()
        }
    }
}