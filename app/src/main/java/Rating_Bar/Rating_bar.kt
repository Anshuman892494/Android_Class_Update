package rating_bar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RatingScreen() {

    var rating by remember { mutableStateOf(3) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Rate this App",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        CustomRatingBar(
            rating = rating,
            onRatingChanged = { rating = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Your Rating: $rating",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun CustomRatingBar(
    maxStars: Int = 5,
    rating: Int,
    onRatingChanged: (Int) -> Unit
) {
    Row {
        for (i in 1..maxStars) {
            Icon(
                imageVector = if (i <= rating) Icons.Filled.Star
                else Icons.Outlined.Star,

                contentDescription = "Star $i",

                tint = if (i <= rating) Color(0xFFFFC107)
                else Color.Gray,

                modifier = Modifier
                    .size(40.dp)
                    .padding(4.dp)
                    .clickable {
                        onRatingChanged(i)
                    }
            )
        }
    }
}