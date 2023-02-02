package com.arsildo.sonata

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.core.view.WindowCompat
import com.arsildo.sonata.theme.SonataTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {

            val followSystemColorScheme = false
            val colorScheme = true
            val dynamicColorsEnabled = true

            SonataTheme(
                darkTheme = if (followSystemColorScheme) isSystemInDarkTheme() else colorScheme,
                dynamicColor = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) dynamicColorsEnabled else false,
                content = { SonataNavigationGraph() }
            )
        }
    }
}