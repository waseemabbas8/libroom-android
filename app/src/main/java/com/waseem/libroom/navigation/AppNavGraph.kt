package com.waseem.libroom.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.waseem.libroom.feature.favorites.presentation.FavoritesScreen
import com.waseem.libroom.feature.home.presentation.HomeScreen
import com.waseem.libroom.feature.profile.presentation.ProfileScreen
import com.waseem.libroom.feature.search.presentation.SearchScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = RootScreen.Home.route
    ) {
        addHomeRoute(navController)
        addSearchRoute(navController)
        addFavoritesRoute(navController)
        addProfileRoute(navController)
    }
}

//home navigation
private fun NavGraphBuilder.addHomeRoute(navController: NavController) {
    navigation(
        route = RootScreen.Home.route,
        startDestination = LeafScreen.Home.route
    ) {
        showHome(navController)
    }
}
private fun NavGraphBuilder.showHome(navController: NavController) {
    composable(route = LeafScreen.Home.route) {
        HomeScreen(viewModel = hiltViewModel())
    }
}
//end of home navigation

//search navigation
private fun NavGraphBuilder.addSearchRoute(navController: NavController) {
    navigation(
        route = RootScreen.Search.route,
        startDestination = LeafScreen.Search.route
    ) {
        showSearch(navController)
    }
}
private fun NavGraphBuilder.showSearch(navController: NavController) {
    composable(route = LeafScreen.Search.route) {
        SearchScreen(viewModel = hiltViewModel())
    }
}
//end of search navigation

//favorites navigation
private fun NavGraphBuilder.addFavoritesRoute(navController: NavController) {
    navigation(
        route = RootScreen.Favorites.route,
        startDestination = LeafScreen.Favorites.route
    ) {
        showFavorites(navController)
    }
}
private fun NavGraphBuilder.showFavorites(navController: NavController) {
    composable(route = LeafScreen.Favorites.route) {
        FavoritesScreen(viewModel = hiltViewModel())
    }
}
//end of favorites navigation

//profile navigation
private fun NavGraphBuilder.addProfileRoute(navController: NavController) {
    navigation(
        route = RootScreen.Profile.route,
        startDestination = LeafScreen.Profile.route
    ) {
        showProfile(navController)
    }
}
private fun NavGraphBuilder.showProfile(navController: NavController) {
    composable(route = LeafScreen.Profile.route) {
        ProfileScreen()
    }
}
//end of profile navigation