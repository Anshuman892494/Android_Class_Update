package Job_Scheduler

import android.Manifest
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresPermission
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobScreen()
        }
    }
}

@Composable
fun JobScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Job Scheduler Demo",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { scheduleJob(context) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Start Job")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { cancelJob(context) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cancel Job")
        }
    }
}


// ✅ Function to Schedule Job
@RequiresPermission(Manifest.permission.RECEIVE_BOOT_COMPLETED)
fun scheduleJob(context: Context) {

    val componentName = ComponentName(context, MyJobService::class.java)

    val jobInfo = JobInfo.Builder(1, componentName)
        .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
        .setPersisted(true)
        .setPeriodic(15 * 60 * 1000) // 15 minutes (minimum)
        .build()

    val jobScheduler =
        context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

    val result = jobScheduler.schedule(jobInfo)

    if (result == JobScheduler.RESULT_SUCCESS) {
        Toast.makeText(context, "Job Scheduled Successfully", Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(context, "Job Scheduling Failed", Toast.LENGTH_SHORT).show()
    }
}


// ✅ Function to Cancel Job
fun cancelJob(context: Context) {
    val jobScheduler =
        context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

    jobScheduler.cancel(1)
    Toast.makeText(context, "Job Cancelled", Toast.LENGTH_SHORT).show()
}