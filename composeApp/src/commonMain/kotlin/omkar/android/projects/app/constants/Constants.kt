package omkar.android.projects.app.constants

class Constants {

    object Screen {
        const val HOME_PAGE = "Home"
        const val PROFILE_PAGE = "Profile"
        const val SUMMARY_PAGE = "Summary"
    }

    object Spike {
        const val APP_NAME = "SPIKE"
    }

    object Spiker {
        const val FETCH_TRANSCRIPT_END_POINT = "example_endpoint"
    }

    object Youtube {
        private const val BASE_YOUTUBE_URL = "https://www.googleapis.com/youtube/v3/"
        const val SEARCH_END_POINT = BASE_YOUTUBE_URL + "search"
        const val SEARCH_SUGGESTION_END_POINT = "https://suggestqueries.google.com/complete/search"
        const val YOUTUBE_DATA_KEY = "AIzaSyBzN2pJNovKrpGMn-HHp6UA5VFUsdfLCxA"
    }
}