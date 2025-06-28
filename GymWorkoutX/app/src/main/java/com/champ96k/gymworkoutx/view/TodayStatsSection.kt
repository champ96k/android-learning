package com.champ96k.gymworkoutx.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.champ96k.gymworkoutx.ui.theme.GymWorkoutXTheme

@Suppress("ktlint:standard:function-naming")
@Composable
fun TodayStatsSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Today Stats", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text("See All", color = Color.Gray, fontSize = 14.sp)
        }

        LazyRow {
            items(listOf("Steps", "Calories", "Heart Rate")) { item ->
                Card(
                    shape = RoundedCornerShape(20.dp),
                    modifier =
                        Modifier
                            .size(140.dp)
                            .padding(8.dp),
                    colors =
                        CardDefaults.cardColors(
                            containerColor = Color(0xFF9F8BFF),
                        ),
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                    ) {
                        Text(item, fontSize = 14.sp, fontWeight = FontWeight.Medium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("900 steps", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("500 kkal", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Preview(showBackground = true)
@Composable
fun TodayStatsSectionPreview() {
    GymWorkoutXTheme {
        DashboardScreen()
    }
}
