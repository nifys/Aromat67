package com.nify.hopp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var settings by remember { mutableStateOf(false) }
            var dark by remember { mutableStateOf(true) }

            MaterialTheme(
                colorScheme = if (dark) darkColorScheme() else lightColorScheme()
            ) {
                if (settings) {
                    Column(
                        Modifier.fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                            .padding(20.dp)
                    ) {
                        TextButton(onClick = { settings = false }) {
                            Text("← Назад")
                        }
                        Text("Настройки", fontSize = 28.sp)
                        HorizontalDivider()
                        Text("Язык: Русский", modifier = Modifier.padding(16.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("Тёмная тема", modifier = Modifier.weight(1f))
                            Switch(dark, { dark = it })
                        }
                        HorizontalDivider()
                        listOf(
                            "Маршрутизация",
                            "Прокси для приложений",
                            "Фрагментация",
                            "Mux",
                            "Настройки VPN",
                            "Подписки"
                        ).forEach {
                            Text(it, modifier = Modifier.padding(16.dp))
                            HorizontalDivider()
                        }
                    }
                } else {
                    Box(
                        Modifier.fillMaxSize().background(
                            Brush.verticalGradient(
                                listOf(Color(0xFF29216F), Color(0xFF090B2C))
                            )
                        )
                    ) {
                        Column(
                            Modifier.fillMaxSize().padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                IconButton(onClick = { settings = true }) {
                                    Icon(Icons.Default.Settings, null, tint = Color.White)
                                }
                                IconButton(onClick = {}) {
                                    Icon(Icons.Default.Add, null, tint = Color.White)
                                }
                            }

                            Spacer(Modifier.height(75.dp))

                            Box(
                                Modifier.size(205.dp).background(
                                    Color(0xFF514CB7), CircleShape
                                ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    Icons.Default.PowerSettingsNew,
                                    null,
                                    tint = Color.White,
                                    modifier = Modifier.size(85.dp)
                                )
                            }

                            Spacer(Modifier.weight(1f))

                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xFF292A61)
                                ),
                                shape = RoundedCornerShape(24.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(Modifier.padding(20.dp)) {
                                    Text("Нет подписки", color = Color.White, fontSize = 22.sp)
                                    Text(
                                        "Добавьте профиль для начала работы",
                                        color = Color.LightGray
                                    )
                                    Spacer(Modifier.height(12.dp))
                                    Text("Hopp", color = Color(0xFF9999FF))
                                }
                            }

                            Spacer(Modifier.height(20.dp))
                            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                                Icon(Icons.Default.ContentPaste, null)
                                Spacer(Modifier.width(8.dp))
                                Text("Импорт из буфера")
                            }
                            Spacer(Modifier.height(15.dp))
                        }
                    }
                }
            }
        }
    }
}
