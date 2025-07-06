package com.champ96k.newsstory.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.champ96k.newsstory.constants.formatDate
import com.champ96k.newsstory.model.Article


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewsCard(article: Article?, modifier: Modifier) {

    val context = LocalContext.current
    val imageRequest = ImageRequest.Builder(context)
        .data(article?.urlToImage)
        .build()
  val  painter = rememberAsyncImagePainter(model = imageRequest)

    Row {

            Image(
                painter,
                contentDescription = article?.publishedAt,
                modifier.width(180.dp)
                    .height(180.dp)
                    .padding(vertical = 16.dp)
                    .border(width = 1.dp, shape = CardDefaults.shape, color = Color.Gray),
                contentScale = ContentScale.FillBounds,
            )



        Column(
             modifier.padding(16.dp)
        ) {
            Text(article?.source?.name ?: "NA")
            Spacer( modifier.height(6.dp))
            Text(article?.title ?: "NA",
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer( Modifier.height(6.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = modifier.fillMaxWidth(),
            ) {
                Text(article?.author ?: "NA",
                    modifier.weight(1f),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Gray
                        ),
                    )

                Text(formatDate(article?.publishedAt?: ""),
                    modifier.weight(1f),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Gray
                        )
                    )
            }
        }
    }
}