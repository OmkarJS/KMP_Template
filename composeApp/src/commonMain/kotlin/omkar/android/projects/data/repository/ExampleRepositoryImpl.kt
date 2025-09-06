package omkar.android.projects.data.repository

import omkar.android.projects.data.model.ExampleResponse
import omkar.android.projects.data.remote.ExampleClient
import omkar.android.projects.data.remote.util.ApiResponseWrapper
import omkar.android.projects.domain.repository.ExampleRepository

class ExampleRepositoryImpl(
    private val exampleClient: ExampleClient
): ExampleRepository {
    override suspend fun fetchExample(): ApiResponseWrapper<ExampleResponse> {
        return exampleClient.fetchExample()
    }
}