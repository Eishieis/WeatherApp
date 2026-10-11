
package com.example.weatherapp

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CurrentWeatherScreen(onForecastClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "My Weather App",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Text("Halifax, Canada", color = BlueAccent, fontSize = 16.sp)

        Spacer(Modifier.height(20.dp))

        Text("🌤️", fontSize = 70.sp)
        Text("22°C", color = Color.White, fontSize = 48.sp)
        Text("Mostly Sunny", color = BlueAccent, fontSize = 20.sp)
        Text("Feels like 24°C", color = Color.LightGray)

        Spacer(Modifier.height(25.dp))

        Card(
            colors = CardDefaults.cardColors(containerColor = DarkCard),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Hourly Forecast", color = Color.White, fontSize = 18.sp)

                Spacer(Modifier.height(12.dp))

                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    HourItem("Now", "🌤️", "22°")
                    HourItem("3 PM", "☀️", "23°")
                    HourItem("4 PM", "⛅", "22°")
                    HourItem("5 PM", "🌥️", "21°")
                    HourItem("6 PM", "🌙", "19°")
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        Card(
            colors = CardDefaults.cardColors(containerColor = DarkCard),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Weather Details", color = Color.White, fontSize = 18.sp)
                Spacer(Modifier.height(10.dp))
                Text("💧 Humidity: 58%", color = Color.LightGray)
                Text("💨 Wind: 12 km/h", color = Color.LightGray)
                Text("☀️ UV Index: Moderate", color = Color.LightGray)
            }
        }

    }
}

@Composable
private fun HourItem(time: String, icon: String, temp: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(time, color = Color.LightGray, fontSize = 12.sp)
        Spacer(Modifier.height(8.dp))
        Text(icon, fontSize = 25.sp)
        Spacer(Modifier.height(8.dp))
        Text(temp, color = Color.White, fontSize = 16.sp)
    }
}
