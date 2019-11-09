package org.tyaa.jetpackcomposedemo1

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.layout.FlexRow
import androidx.ui.layout.Padding
import androidx.ui.material.Button
import androidx.ui.material.Divider

@Composable
fun fullWidthButton(action: () -> Unit){
    FlexRow{
        expanded(0.8f){
            Padding(4.dp) {
                Button("Get List", action)
            }
        }
    }
}

@Composable
fun listItem(name: String){
    Padding(6.dp) {
        Text(name)
    }
    Divider()
}