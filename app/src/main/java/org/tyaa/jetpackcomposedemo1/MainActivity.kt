package org.tyaa.jetpackcomposedemo1

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.core.content.res.ResourcesCompat
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsStory()
        }
    }
}

@Composable
fun NewsStory() {
    // Use 'mipmap' directory instead of 'drawable'!
    val image = +imageResource(R.mipmap.header)
    Column(
        crossAxisSize = LayoutSize.Expand,
        modifier=Spacing(16.dp)
    ) {
        Container(expanded = true, height = 180.dp) {
            DrawImage(image)
        }
        HeightSpacer(16.dp)
        Text("A day in Shark Fin Cove")
        Text("Davenport, California")
        Text("December 2018")
    }
}

@Preview
@Composable
fun DefaultPreview() {
    NewsStory()
}
