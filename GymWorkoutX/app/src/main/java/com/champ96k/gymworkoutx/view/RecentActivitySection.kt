package com.champ96k.gymworkoutx.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.champ96k.gymworkoutx.R
import com.champ96k.gymworkoutx.ui.theme.GymWorkoutXTheme
import com.champ96k.gymworkoutx.view.constants.Constants

@Suppress("ktlint:standard:function-naming")
@Composable
fun RecentActivitySection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Recent Activity", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text("See All", color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFEFF5F5)),
        ) {
            Image(
                painter = painterResource(R.drawable.gym_card),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)),

            )
        }

        LazyColumn {
            items(Constants.exprencies)  { item ->
                Card(
                    shape = RoundedCornerShape(10.dp),
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(item),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text("Jogging at Park", fontWeight = FontWeight.Bold)
                            Text("3 Apr · 07:00 am", color = Color.Gray)
                        }
                    }
                }


            }
        }


    }
}

@Suppress("ktlint:standard:function-naming")
@Preview(showBackground = true)
@Composable
fun RecentActivitySectionPreview() {
    GymWorkoutXTheme {
        DashboardScreen()
    }
}
