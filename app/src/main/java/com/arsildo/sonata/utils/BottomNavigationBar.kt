package com.arsildo.sonata.utils

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.LibraryBooks
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.arsildo.sonata.Destinations

sealed class BottomBarItem(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val iconFilled: ImageVector
) {

    object Books : BottomBarItem(
        route = Destinations.BOOKS_ROUTE,
        title = "Books",
        icon = Icons.Outlined.Book,
        iconFilled = Icons.Filled.Book
    )

    object Library : BottomBarItem(
        route = Destinations.LIBRARY_ROUTE,
        title = "Library",
        icon = Icons.Outlined.LibraryBooks,
        iconFilled = Icons.Filled.LibraryBooks
    )

    object Preferences : BottomBarItem(
        route = Destinations.PREFERENCES_ROUTE,
        title = "Preferences",
        icon = Icons.Outlined.Settings,
        iconFilled = Icons.Filled.Settings
    )

}


@Composable
fun BottomNavigationBar(navController: NavHostController) {

    val items = listOf(
        BottomBarItem.Books,
        BottomBarItem.Library,
        BottomBarItem.Preferences,
    )


    NavigationBar(
        windowInsets = WindowInsets.navigationBars,
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            val selected = (currentDestination?.hierarchy?.any { it.route == screen.route } == true)
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = if (selected) screen.iconFilled else screen.icon,
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                },
                selected = selected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primaryContainer,
                    indicatorColor = MaterialTheme.colorScheme.onBackground
                )
            )
        }
    }

}