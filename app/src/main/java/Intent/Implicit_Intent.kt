package Intent

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun IntentScreen() {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .statusBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Button(onClick = {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:9876543210")
            context.startActivity(intent)
        }) {
            Text("Open Dialer")
        }

        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com")
            context.startActivity(intent)
        }) {
            Text("Open Website")
        }

        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("geo:0,0?q=Delhi")
            context.startActivity(intent)
        }) {
            Text("Open Map")
        }

        Button(onClick = {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:example@gmail.com")
            context.startActivity(intent)
        }) {
            Text("Send Email")
        }

        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("sms:9876543210")
            context.startActivity(intent)
        }) {
            Text("Send SMS")
        }

        Button(onClick = {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            context.startActivity(intent)
        }) {
            Text("Open Camera")
        }

        Button(onClick = {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            context.startActivity(intent)
        }) {
            Text("Open Gallery")
        }

        Button(onClick = {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Hello Anshu")

            context.startActivity(
                Intent.createChooser(intent, "Share via")
            )
        }) {
            Text("Share Text")
        }
    }
}

@Composable
fun PutExtraExample() {

    val context = LocalContext.current

    Column {

        Button(onClick = {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")

            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("example@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hello Anshu")
            intent.putExtra(Intent.EXTRA_TEXT, "This is a test email")

            context.startActivity(intent)
        }) {
            Text("Send Email ")
        }

        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("sms:9876543210")

            intent.putExtra("sms_body", "Hello from Compose")

            context.startActivity(intent)
        }) {
            Text("Send SMS")
        }

        Button(onClick = {
            val intent = Intent(Intent.ACTION_SEND)

            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Hello Anshu 😄🔥")

            context.startActivity(
                Intent.createChooser(intent, "Share via")
            )
        }) {
            Text("Share Text 🔗")
        }
    }
}