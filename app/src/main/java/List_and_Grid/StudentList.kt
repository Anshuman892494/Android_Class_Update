package List_and_Grid

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun StudentList() {

    val students = listOf(
        "Rahul Sharma",
        "Priya Verma",
        "Aman Gupta",
        "Sneha Patel",
        "Vishal Khanna"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(50.dp)
    ) {
        items(students) { student ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 18.dp),
                colors = CardDefaults.cardColors(Red),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Text(
                    text = student,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 18.sp
                )
            }
        }
    }
}
