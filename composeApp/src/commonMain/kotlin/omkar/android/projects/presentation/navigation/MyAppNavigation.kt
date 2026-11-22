package omkar.android.projects.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import omkar.android.projects.app.constants.Constants.Routes
import omkar.android.projects.app.utils.navigateToHomeScreen
import omkar.android.projects.app.utils.navigateToProfileScreen
import omkar.android.projects.presentation.home.HomePage
import omkar.android.projects.presentation.profile.ProfilePage

@Composable
fun MyAppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomePage(
                onProfileClicked = {
                    navController.navigateToProfileScreen()
                }
            )
        }

        composable(Routes.PROFILE) {
            ProfilePage(
                onHomeClick = {
                    navController.navigateToHomeScreen()
                }
            )
        }
    }
}