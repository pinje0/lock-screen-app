package com.example.lockscreenapp

import android.os.Bundle
import android.provider.Settings
import android.view.KeyEvent
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private var exitCallback: (() -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // brightness 0%
        try {
            val lp = window.attributes
            lp.screenBrightness = 0.0f
            window.attributes = lp
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // sembunyikan navbar/status bar
        window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        setContent {
            MaterialTheme {
                ScreenDimmer(onFinish = { finish() }, onExitRegister = { exitCallback = it })
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            exitCallback?.invoke()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            Settings.System.putInt(
                contentResolver,
                Settings.System.SCREEN_BRIGHTNESS_MODE,
                Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC
            )
        } catch (_: Exception) {}
    }
}

@Composable
fun ScreenDimmer(onFinish: () -> Unit, onExitRegister: (()->Unit)->Unit) {
    val scope = rememberCoroutineScope()
    var tapCount by remember { mutableStateOf(0) }
    var lastTapTime by remember { mutableStateOf(0L) }

    onExitRegister { scope.launch { onFinish() } }

    LaunchedEffect(Unit) {
        delay(15000)
        onFinish()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.TopStart
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color(0xFF111111).copy(alpha = 0.08f))
                .clickable {
                    val now = System.currentTimeMillis()
                    if (now - lastTapTime > 600) tapCount = 0
                    tapCount++
                    lastTapTime = now
                    if (tapCount >= 3) {
                        scope.launch { onFinish() }
                        tapCount = 0
                    }
                }
        )
    }
}
