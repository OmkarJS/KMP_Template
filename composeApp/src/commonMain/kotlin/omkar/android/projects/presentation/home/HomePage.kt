package omkar.android.projects.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import omkar.android.projects.app.widget.HomeRoofView
import omkar.android.projects.presentation.navigation.Screens
import omkar.android.projects.presentation.theme.LocalAppColors
import org.koin.compose.koinInject

@Composable
fun HomePage() {
    val navigator = LocalNavigator.currentOrThrow
    val colors = LocalAppColors.current
    val homeViewModel: HomeViewModel = koinInject()

    // Search
    var searchText by remember { mutableStateOf("") }
    var isSearching by remember { mutableStateOf(false) }
    val exampleState by homeViewModel.exampleState.collectAsState()

    fun hideSearchSuggestion() {
        searchText = ""
        isSearching = false
    }

    Scaffold(
        topBar = {
            HomeRoofView(
                colors = colors,
                isSearching = isSearching,
                searchText = searchText,
                onTextChange = {
                    searchText = it
                },
                onSearchClick = { searchQuery ->
                    hideSearchSuggestion()
                },
                onSearchBarClick = {
                    isSearching = true
                },
                onProfileClick = {
                    navigator.push(Screens.ProfilePage)
                },
                onCloseSearch = {
                    hideSearchSuggestion()
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}

