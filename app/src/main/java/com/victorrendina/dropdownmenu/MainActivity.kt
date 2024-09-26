package com.victorrendina.dropdownmenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import com.victorrendina.dropdownmenu.ui.theme.DropdownMenuIssueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DropdownMenuIssueTheme {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        var expanded by remember { mutableStateOf(false) }
                        var size by remember { mutableStateOf(IntSize.Zero) }

                        Box(modifier = Modifier.align(Alignment.Center)) {
                            Button(
                                onClick = {
                                    expanded = !expanded
                                }) {
                                Text("Open Dropdown Menu")
                            }

                            DropdownMenu(
                                modifier = Modifier.onSizeChanged {
                                    size = it
                                },
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                Text("Size = $size")
                                repeat(50) {
                                    DropdownMenuItem(
                                        text = {
                                            Text("Item $it")
                                        },
                                        onClick = {}
                                    )
                                }
                            }
                        }
                    }
                }
            }
    }
}