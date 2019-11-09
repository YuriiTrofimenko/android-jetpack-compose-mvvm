package org.tyaa.jetpackcomposedemo1

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.themeTextStyle
import androidx.ui.material.withOpacity
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProviders.of(this)[MainViewModel::class.java]
        setContent {
            MaterialTheme {
                // NewsStory()
                MyDemoList(
                    viewModel.randomNumbersModel.list,
                    viewModel::getRandomNumbers
                )
            }
        }
    }
}

@Composable
fun NewsStory() {
    // Use 'mipmap' directory instead of 'drawable'!
    val image = +imageResource(R.mipmap.header)
    Column(
        crossAxisSize = LayoutSize.Expand,
        modifier = Spacing(16.dp)
    ) {

        Container(expanded = true, height = 180.dp) {
            Clip(shape = RoundedCornerShape(8.dp)) {
                DrawImage(image)
            }
        }
        HeightSpacer(16.dp)
        Text("A day wandering through the sandhills in Shark " +
                "Fin Cove, and a few of the sights I saw",
            maxLines = 2, overflow = TextOverflow.Ellipsis,
            style = (+themeTextStyle { h6 }).withOpacity(0.87f))
        Text("Davenport, California",
            style = (+themeTextStyle { body2 }).withOpacity(0.87f))
        Text("December 2018",
            style = (+themeTextStyle { body2 }).withOpacity(0.6f))
    }
}

@Composable
fun MyDemoList(list: List<String>, action: () -> Unit) {
    FlexColumn {
        expanded(1f){
            VerticalScroller {
                Column {
                    list.forEach{
                        listItem(it)
                    }
                }
            }
        }
        inflexible{
            fullWidthButton(action)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    NewsStory()
}
