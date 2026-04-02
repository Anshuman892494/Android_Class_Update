package Date_Time_Picker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DateTimeScreen()
        }
    }
}

@Composable
fun DateTimeScreen() {

    val context = LocalContext.current
    var selectedDate by remember { mutableStateOf("") }
    var selectedTime by remember { mutableStateOf("") }
    val calendar = Calendar.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text("Date & Time Picker", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        // 📅 Date Button
        Button(
            onClick = {
                val datePicker = DatePickerDialog(
                    context,
                    { _, year, month, dayOfMonth ->
                        selectedDate = "$dayOfMonth/${month + 1}/$year"
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                )
                datePicker.show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Select Date")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text("Selected Date: $selectedDate")

        Spacer(modifier = Modifier.height(20.dp))

        // ⏰ Time Button
        Button(
            onClick = {
                val timePicker = TimePickerDialog(
                    context,
                    { _, hourOfDay, minute ->
                        selectedTime = "$hourOfDay:$minute"
                    },
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    false
                )
                timePicker.show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Select Time")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text("Selected Time: $selectedTime")
    }
}