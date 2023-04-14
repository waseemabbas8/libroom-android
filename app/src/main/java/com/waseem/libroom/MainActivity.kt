package com.waseem.libroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.waseem.libroom.core.ui.theme.LIBroomTheme
import com.waseem.libroom.feature.root.MainScreen

class MainActivity : ComponentActivity() {
//    private val shouldUseDualMode = MutableLiveData<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
//        lifecycleScope.launch {
//            WindowInfoTracker.getOrCreate(this@MainActivity)
//                .windowLayoutInfo(this@MainActivity)
//                .collect { windowInfo ->
//                    reserveScreenState(windowInfo.displayFeatures)
//                }
//        }
        setContent {
            LIBroomTheme {
                MainScreen()
            }
        }
    }

//    private fun reserveScreenState(displayFeatures: List<DisplayFeature>) {
//        var isDualMode = false
//
//        val isScreenSpanned = displayFeatures.isNotEmpty()
//        if (isScreenSpanned) {
//            val foldingFeature = displayFeatures.first() as FoldingFeature
//            val isVertical = foldingFeature.orientation == FoldingFeature.Orientation.VERTICAL
//            isDualMode = isVertical
//        }
//        shouldUseDualMode.value = isDualMode
//    }
}