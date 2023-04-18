package com.example.ui

import com.airbnb.android.showkase.annotation.ShowkaseScreenshot
import com.airbnb.android.showkase.screenshot.testing.paparazzi.PaparazziShowkaseScreenshotTest

@ShowkaseScreenshot(rootShowkaseClass = RootModule::class)
abstract class MyPaparazziShowkaseScreenshotTest: PaparazziShowkaseScreenshotTest {
    companion object: PaparazziShowkaseScreenshotTest.CompanionObject
}

//class MyPaparazziTest {
//    @get:Rule
//    val paparazzi = Paparazzi(
//        deviceConfig = DeviceConfig.PIXEL_6_PRO.copy(softButtons = false),
//        renderingMode = SessionParams.RenderingMode.SHRINK
//    )
//
//    @Test
//    fun `test homescreen`() {
//        paparazzi.snapshot {
//            HomeScreen()
//        }
//    }
//}