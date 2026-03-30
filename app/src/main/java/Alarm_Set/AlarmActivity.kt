package Alarm_Set

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.util.Calendar

class AlarmActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlarmScreen()
        }
    }
}

@Composable
fun AlarmScreen() {
    val context = LocalContext.current
    var timeInMillis by remember { mutableStateOf(0L) }

    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {

        Text(
            text = "Alarm Manager Demo",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))

        Button(
            onClick = {
                val calendar = Calendar.getInstance().apply {
                    add(Calendar.SECOND, 10)
                }
                timeInMillis = calendar.timeInMillis
                if (checkExactAlarmPermission(context)) {
                    setAlarm(context, timeInMillis)
                } else {
                    requestExactAlarmPermission(context)
                }
            }
        ) {
            Text("Set Alarm (10 sec)")
        }
    }
}

fun checkExactAlarmPermission(context: Context): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.canScheduleExactAlarms()
    } else {
        true
    }
}

fun requestExactAlarmPermission(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        try {
            val intent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM)
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Enable exact alarm permission manually", Toast.LENGTH_LONG)
                .show()
        }
    }
}

@SuppressLint("ScheduleExactAlarm")
fun setAlarm(context: Context, triggerAtMillis: Long) {
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE)
            as AlarmManager

    val intent = Intent(context, AlarmReceiver::class.java)
    val pendingIntent = PendingIntent.getBroadcast(
        context,
        0,
        intent,
        PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
    )

    alarmManager.setExact(
        AlarmManager.RTC_WAKEUP,
        triggerAtMillis,
        pendingIntent
    )

    Toast.makeText(context, "Alarm Set!", Toast.LENGTH_SHORT).show()
}