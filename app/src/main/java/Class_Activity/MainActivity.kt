package Class_Activity

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
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Dashboard()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(){
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                navigationIcon = {
                    IconButton(onClick = { /* TODO: Open drawer or menu */ }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                title = {
                    Text("Dashboard")
                },
                actions = {
                    IconButton(onClick = { /* TODO: Open profile */ }) {
                        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Welcome, Anshu!",
                style = MaterialTheme.typography.headlineMedium
            )

            Button(
                onClick = { /* TODO: Navigate to Class Schedule */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("View Class Schedule")
            }
        }
    }
}