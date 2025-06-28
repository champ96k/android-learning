package com.champ96k.gymworkoutx.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.champ96k.gymworkoutx.ui.theme.GymWorkoutXTheme

@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderSection() {
    TopAppBar(
        modifier = Modifier.padding(horizontal = 16.dp),
        title = {
            Column {
                Text(
                    "Welcome \uD83D\uDC4B",
                    style =
                        TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Thin,
                        ),
                )
                Text(
                    "Tushar Nikam",
                    style =
                        TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                        ),
                )
            }
        },
        navigationIcon = {
            Icon(Icons.Default.AccountCircle, contentDescription = null)
        },
        actions = {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp),
            )
            Icon(Icons.Default.Notifications, contentDescription = null)
        },
    )
}

@Suppress("ktlint:standard:function-naming")
@Preview(showBackground = true)
@Composable
fun HeaderSectionPreview() {
    GymWorkoutXTheme { DashboardScreen() }
}
