package List_and_Grid

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun StudentDashboard() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = "Subjects",
            fontSize = 22.sp,
            modifier = Modifier.padding(
                top = 32.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 8.dp
            )
        )

        SubjectRow()

        Text(
            text = "Students",
            fontSize = 22.sp,
            modifier = Modifier.padding(16.dp)
        )

        StudentList()

        Text(
            text = "Courses",
            fontSize = 22.sp,
            modifier = Modifier.padding(16.dp)
        )

        CourseGrid()
    }
}