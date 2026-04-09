package Material_UI_Example

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text="Material & Foundation Demo",
                        fontWeight = FontWeight.Bold
                    )},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red,
                    titleContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}
            ) {
                Text("+")
            }
        },
        floatingActionButtonPosition = FabPosition.End

    ) { paddingValues ->
        MainScreen(paddingValues)
    }
}

@Composable
fun MainScreen(paddingValues: PaddingValues) {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }

    val itemsList = listOf(
        "Android", "Kotlin", "Jetpack Compose",
        "Material UI", "RecyclerView", "Retrofit",
        "Room DB", "Firebase"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)
    ) {

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Welcome Student")
                Text("Demo App")
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Enter Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text("Submit")
            }

            Spacer(modifier = Modifier.height(16.dp))
        }


        items(itemsList) { item ->
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable {
                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                    }
            ) {
                Text(
                    text = item,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}