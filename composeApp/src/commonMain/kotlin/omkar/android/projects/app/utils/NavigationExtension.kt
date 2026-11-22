package omkar.android.projects.app.utils

import androidx.navigation.NavController
import omkar.android.projects.app.constants.Constants

fun NavController.navigateToHomeScreen() {
    this.navigate(Constants.Routes.HOME)
}

fun NavController.navigateToProfileScreen() {
    this.navigate(Constants.Routes.PROFILE)
}