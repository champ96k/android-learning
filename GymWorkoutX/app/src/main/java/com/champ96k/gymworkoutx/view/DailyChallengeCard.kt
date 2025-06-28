package com.champ96k.gymworkoutx.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.champ96k.gymworkoutx.ui.theme.GymWorkoutXTheme

@Suppress("ktlint:standard:function-naming")
@Composable
fun DailyChallengeCard() {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
                colors =
            CardDefaults.cardColors(
                containerColor = Color(0xFF9F8BFF),
            ),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text("Daily Challenge", color = Color.White, fontWeight = FontWeight.Bold)
                Text("Sprint for 30 seconds, Repeat 5x", color = Color.White)
            }
            Button(
                onClick = { /* Done */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            ) {
                Text("Done", color = Color(0xFF9F8BFF))
            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Preview(showBackground = true)
@Composable
fun DailyChallengeCardPreview() {
    GymWorkoutXTheme { DashboardScreen() }
}
