
package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.theme.WeatherAppTheme

val DarkBackground = Color(0xFF121826)
val DarkCard = Color(0xFF222C3D)
val BlueAccent = Color(0xFF64B5F6)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeatherAppTheme {
                var selectedScreen by remember { mutableIntStateOf(0) }

                Scaffold(
                    containerColor = DarkBackground,
                    bottomBar = {
                        NavigationBar(
                            containerColor = DarkCard
                        ) {
                            NavigationBarItem(
                                selected = selectedScreen == 0,
                                onClick = { selectedScreen = 0 },
                                icon = { Text("☀️") },
                                label = { Text("Today") }
                            )

                            NavigationBarItem(
                                selected = selectedScreen == 1,
                                onClick = { selectedScreen = 1 },
                                icon = { Text("📅") },
                                label = { Text("Forecast") }
                            )
                        }
                    }
                ) { padding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {
                        if (selectedScreen == 0) {
                            CurrentWeatherScreen {
                                selectedScreen = 1
                            }
                        } else {
                            ForecastScreen {
                                selectedScreen = 0
                            }
                        }
                    }
                }
            }
        }
    }
}
