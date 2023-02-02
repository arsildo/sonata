package com.arsildo.sonata

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arsildo.sonata.utils.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SonataNavigationGraph() {

    val navController = rememberNavController()

    Scaffold(
        contentWindowInsets = WindowInsets(top = 0, bottom = 0),
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Destinations.BOOKS_ROUTE,
            modifier = Modifier
                .padding(contentPadding)
                .padding(horizontal = 16.dp)
                .background(MaterialTheme.colors.background)
        ) {

            composable(route = Destinations.BOOKS_ROUTE) {

            }

            composable(route = Destinations.LIBRARY_ROUTE) {

            }

            composable(route = Destinations.PREFERENCES_ROUTE) {

            }

        }
    }

}
