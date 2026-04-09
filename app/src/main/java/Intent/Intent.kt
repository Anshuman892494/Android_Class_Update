package Intent

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import kotlin.jvm.java


@Composable
fun intent(){
    val context = LocalContext.current
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .statusBarsPadding()
    ) {
//        Button(
//            onClick = {
//            val intent = Intent(context, SecondActivity::class.java)
//            context.startActivity(intent)
//        }) {
//            Text("Open Screen")
//        }

        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
            context.startActivity(intent)
        }) {
            Text("Open Browser")
        }
    }
}