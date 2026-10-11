
package com.example.weatherapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private data class WeatherDay(
    val day: String,
    val icon: String,
    val condition: String,
    val high: String,
    val low: String
)

@Composable
fun ForecastScreen(onBack: () -> Unit) {
    val days = listOf(
        WeatherDay("Sunday", "☀️", "Sunny", "24°", "16°"),
        WeatherDay("Monday", "🌤️", "Partly Cloudy", "23°", "15°"),
        WeatherDay("Tuesday", "☁️", "Cloudy", "20°", "14°"),
        WeatherDay("Wednesday", "🌧️", "Light Rain", "18°", "12°"),
        WeatherDay("Thursday", "🌤️", "Mostly Sunny", "22°", "15°"),
        WeatherDay("Friday", "⛅", "Partly Cloudy", "21°", "14°"),
        WeatherDay("Saturday", "🌦️", "Light Showers", "19°", "13°"),
        WeatherDay("Sunday", "☀️", "Sunny", "25°", "17°"),
        WeatherDay("Monday", "🌤️", "Mostly Sunny", "23°", "16°"),
        WeatherDay("Tuesday", "🌧️", "Rainy", "18°", "12°")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        Text(
            text = "10-Day Forecast",
            color = Color.White,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Halifax, Canada",
            color = BlueAccent,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        days.forEach { day ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = DarkCard
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = day.icon,
                        fontSize = 28.sp
                    )

                    Spacer(modifier = Modifier.width(14.dp))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = day.day,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = day.condition,
                            color = Color.LightGray,
                            fontSize = 13.sp
                        )
                    }

                    Text(
                        text = "${day.high} / ${day.low}",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }
        }



        Spacer(modifier = Modifier.height(16.dp))
    }
}
