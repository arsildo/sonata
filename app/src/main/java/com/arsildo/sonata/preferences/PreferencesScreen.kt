package com.arsildo.sonata.preferences

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Backpack
import androidx.compose.material.icons.rounded.FormatPaint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreferencesScreen(viewModel: PreferencesViewModel = hiltViewModel()) {
    Scaffold(
        contentWindowInsets = WindowInsets.statusBars,
        modifier = Modifier.fillMaxSize()
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                PreferenceItem(
                    title = "Follow System",
                    subtitle = "System colors",
                    icon = Icons.Rounded.FormatPaint
                )
                PreferenceItem(
                    title = "Back press",
                    subtitle = "double press",
                    icon = Icons.Rounded.Backpack
                )
            }
        }


    }
}

@Composable
fun ColumnScope.PreferenceItem(
    title: String,
    subtitle: String,
    icon: ImageVector
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(imageVector = icon, contentDescription = null)
            Column {
                Text(title)
                Text(subtitle)
            }
        }
        Switch(checked = true, onCheckedChange = {})
    }

}


@Composable // This composable animates between theme transitions
fun AnimateColorSchemeTransition(content: @Composable () -> Unit) {
    val colors = MaterialTheme.colorScheme.copy(
        background = animateColorAsState(
            targetValue = MaterialTheme.colorScheme.background,
            animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
        ).value,
        primary = animateColorAsState(
            targetValue = MaterialTheme.colorScheme.primary,
            animationSpec = tween(easing = LinearEasing, delayMillis = 256)
        ).value,
        secondary = animateColorAsState(
            targetValue = MaterialTheme.colorScheme.primary,
            animationSpec = tween(easing = LinearOutSlowInEasing, delayMillis = 256)
        ).value,
    )
    MaterialTheme(colorScheme = colors, content = content)
}