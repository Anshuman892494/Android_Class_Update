package Scroll_practice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NestedScrollExample() {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {

        Text(text = "Top Section", fontSize = 24.sp, modifier = Modifier.padding(10.dp))

        LazyColumn(
            modifier = Modifier
                .height(300.dp)
        ) {

            items(20) { index ->
                Text(
                    text = "Nested Item $index",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }

        }

        Text(
            text = "Bottom Section",
            fontSize = 24.sp,
            modifier = Modifier.padding(10.dp)
        )

    }
}