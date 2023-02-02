package com.arsildo.sonata

import androidx.navigation.NavHostController
import com.arsildo.sonata.Screens.BOOKS_SCREEN
import com.arsildo.sonata.Screens.BOOK_SHOWCASE_SCREEN
import com.arsildo.sonata.Screens.LIBRARY_SCREEN
import com.arsildo.sonata.Screens.PREFERENCES_SCREEN

const val ROOT_GRAPH_ROUTE = "root"

const val CONTENT_GRAPH_ROUTE = "content"
const val PREFERENCES_GRAPH_ROUTE = "preferences"

object Screens {

    const val BOOKS_SCREEN = "books"
    const val BOOK_SHOWCASE_SCREEN = "bookShowcase"


    const val LIBRARY_SCREEN = "library"

    const val PREFERENCES_SCREEN = "preferenceScreen"
}

object Destinations {

    const val BOOKS_ROUTE = BOOKS_SCREEN
    const val BOOK_SHOWCASE_ROUTE = BOOK_SHOWCASE_SCREEN

    const val LIBRARY_ROUTE = LIBRARY_SCREEN

    const val PREFERENCES_ROUTE = PREFERENCES_SCREEN
}

class NavigationActions(navController: NavHostController) {

}