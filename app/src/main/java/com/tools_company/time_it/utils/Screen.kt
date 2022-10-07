package com.tools_company.time_it.utils

sealed class Screen(val route: String) {
    object HomeScreen: Screen(route = "home_screen")
    object AddEventScreen: Screen(route = "add_event_screen")
}
