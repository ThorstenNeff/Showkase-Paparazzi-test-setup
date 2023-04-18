package com.example.ui

import com.airbnb.android.showkase.annotation.ShowkaseScreenshot
import com.airbnb.android.showkase.screenshot.testing.paparazzi.PaparazziShowkaseScreenshotTest

@ShowkaseScreenshot(rootShowkaseClass = RootModule::class)
abstract class PaparazziTest: PaparazziShowkaseScreenshotTest {
    companion object: PaparazziShowkaseScreenshotTest.CompanionObject
}