package mx.edu.utez.yara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import mx.edu.utez.yara.ui.navigation.NavGraph
import mx.edu.utez.yara.ui.theme.Liverpool_YaraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Liverpool_YaraTheme {
                NavGraph()
            }
        }
    }
}