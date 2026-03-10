package my_files

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SubjectRow() {

    val subjects = listOf(
        "Maths",
        "Science",
        "English",
        "History",
        "Computer"
    )

    LazyRow(
        modifier = Modifier.padding(16.dp)
    ) {

        items(subjects) { subject ->

            Card(
                modifier = Modifier.padding(end = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {

                Text(
                    text = subject,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}
