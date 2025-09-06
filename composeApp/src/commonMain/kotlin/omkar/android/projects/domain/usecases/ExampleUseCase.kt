package omkar.android.projects.domain.usecases

import omkar.android.projects.data.model.ExampleResponse
import omkar.android.projects.data.remote.util.ApiResponseWrapper
import omkar.android.projects.domain.repository.ExampleRepository

class ExampleUseCase(
    private val exampleRepository: ExampleRepository
) {
    suspend operator fun invoke(): ApiResponseWrapper<ExampleResponse> {
        return exampleRepository.fetchExample()
    }
}