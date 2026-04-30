package Runtime_Permissions

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PermissionScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PermissionScreen() {

    val context = LocalContext.current

    val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        Manifest.permission.READ_MEDIA_IMAGES
    } else {
        Manifest.permission.READ_EXTERNAL_STORAGE
    }

    var permissionGranted by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                permission
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        permissionGranted = isGranted
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Runtime Permission in Compose") })
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = if (permissionGranted)
                    "Permission Granted ✅"
                else
                    "Permission Required ❌"
            )

            Spacer(modifier = Modifier.height(20.dp))

            if (!permissionGranted) {
                Button(onClick = {
                    launcher.launch(permission)
                }) {
                    Text("Request Permission")
                }
            } else {
                Button(onClick = {
                    Toast.makeText(context, "Accessing images now that permission is granted!", Toast.LENGTH_SHORT).show()
                }) {
                    Text("Proceed with Feature")
                }
            }
        }
    }
}