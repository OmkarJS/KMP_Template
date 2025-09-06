package omkar.android.projects.presentation.home

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import omkar.android.projects.data.remote.util.ApiResponseWrapper
import omkar.android.projects.domain.usecases.ExampleUseCase
import omkar.android.projects.presentation.expectuals.getViewModelScope

class HomeViewModel(
    private val exampleUseCase: ExampleUseCase
) {
    private val viewModelScope: CoroutineScope = getViewModelScope()

    // Example State
    private val _exampleState = MutableStateFlow("")
    val exampleState: StateFlow<String> = _exampleState.asStateFlow()

    // Example Network call from usecase
    fun fetch() {
        viewModelScope.launch {
            when(exampleUseCase.invoke()) {
                is ApiResponseWrapper.Success -> {}

                is ApiResponseWrapper.Failure -> {}

                is ApiResponseWrapper.NetworkError -> {}

                is ApiResponseWrapper.UnknownError -> {}
            }
        }
    }
}