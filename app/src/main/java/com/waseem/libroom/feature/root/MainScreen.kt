package com.waseem.libroom.feature.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.FavoriteIcon
import com.waseem.libroom.core.compose.HomeIcon
import com.waseem.libroom.core.compose.ProfileIcon
import com.waseem.libroom.core.compose.SearchIcon
import com.waseem.libroom.core.ui.ThemedPreview
import com.waseem.libroom.navigation.AppNavGraph
import com.waseem.libroom.navigation.LeafScreen
import com.waseem.libroom.navigation.RootScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentSelectedScreen by navController.currentScreenAsState()
    val bottomNavRoutes = listOf(
        LeafScreen.Home.route,
        LeafScreen.Search.route,
        LeafScreen.Favorites.route,
        LeafScreen.Profile.route,
    )
    val currentRoute by navController.currentRouteAsState()
    Scaffold(
        bottomBar = {
            if (currentRoute == null || bottomNavRoutes.contains(currentRoute)) {
                BottomNavBar(navController = navController, currentSelectedScreen = currentSelectedScreen)
            }
        },
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            AppNavGraph(navController = navController)
        }
    }
}

@Composable
private fun BottomNavBar(
    navController: NavController,
    currentSelectedScreen: RootScreen
) {
    NavigationBar {
        NavigationBarItem(
            selected = currentSelectedScreen == RootScreen.Home,
            onClick = { navController.navigateToRootScreen(RootScreen.Home) },
            alwaysShowLabel = true,
            label = {
                Text(text = stringResource(id = R.string.home))
            },
            icon = {
                HomeIcon()
            }
        )
        NavigationBarItem(
            selected = currentSelectedScreen == RootScreen.Search,
            onClick = { navController.navigateToRootScreen(RootScreen.Search) },
            alwaysShowLabel = true,
            label = {
                Text(text = stringResource(id = R.string.search))
            },
            icon = {
                SearchIcon()
            }
        )
        NavigationBarItem(
            selected = currentSelectedScreen == RootScreen.Favorites,
            onClick = { navController.navigateToRootScreen(RootScreen.Favorites) },
            alwaysShowLabel = true,
            label = {
                Text(text = stringResource(id = R.string.favorites))
            },
            icon = {
                FavoriteIcon()
            }
        )
        NavigationBarItem(
            selected = currentSelectedScreen == RootScreen.Profile,
            onClick = { navController.navigateToRootScreen(RootScreen.Profile) },
            alwaysShowLabel = true,
            label = {
                Text(text = stringResource(id = R.string.profile))
            },
            icon = {
                ProfileIcon()
            }
        )
    }
}

@Stable
@Composable
private fun NavController.currentScreenAsState(): State<RootScreen> {
    val selectedItem = remember { mutableStateOf<RootScreen>(RootScreen.Home) }
    DisposableEffect(key1 = this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            when {
                destination.hierarchy.any { it.route == RootScreen.Home.route } -> {
                    selectedItem.value = RootScreen.Home
                }
                destination.hierarchy.any { it.route == RootScreen.Search.route } -> {
                    selectedItem.value = RootScreen.Search
                }
                destination.hierarchy.any { it.route == RootScreen.Favorites.route } -> {
                    selectedItem.value = RootScreen.Favorites
                }
                destination.hierarchy.any { it.route == RootScreen.Profile.route } -> {
                    selectedItem.value = RootScreen.Profile
                }
            }

        }
        addOnDestinationChangedListener(listener)
        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }
    return selectedItem
}

@Stable
@Composable
private fun NavController.currentRouteAsState(): State<String?> {
    val selectedItem = remember { mutableStateOf<String?>(null) }
    DisposableEffect(this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            selectedItem.value = destination.route
        }
        addOnDestinationChangedListener(listener)

        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }
    return selectedItem
}

private fun NavController.navigateToRootScreen(rootScreen: RootScreen) {
    navigate(rootScreen.route) {
        launchSingleTop = true
        restoreState = true
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
    }
}

@Preview
@Composable
private fun BottomNavBarLightTheme() {
    ThemedPreview {
        BottomNavBar(navController = rememberNavController(), currentSelectedScreen = RootScreen.Home)
    }
}