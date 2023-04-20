package com.example.ui

import androidx.activity.OnBackPressedDispatcher
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.airbnb.android.showkase.annotation.ShowkaseScreenshot
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserColor
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.airbnb.android.showkase.models.ShowkaseBrowserTypography
import com.airbnb.android.showkase.screenshot.testing.paparazzi.PaparazziShowkaseScreenshotTest
import com.airbnb.android.showkase.ui.padding4x
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

/*
@ShowkaseScreenshot(rootShowkaseClass = RootModule::class)
abstract class PaparazziTest: PaparazziShowkaseScreenshotTest {
    companion object: PaparazziShowkaseScreenshotTest.CompanionObject
}
*/

@RunWith(TestParameterInjector::class)
class PaparazziSampleScreenshotTest {

    object PreviewProvider : TestParameter.TestParameterValuesProvider {
        override fun provideValues(): List<TestPreview> {
            val metadata = Showkase.getMetadata()
            val components = metadata.componentList.map(::ComponentTestPreview)
            val colors = metadata.colorList.map(::ColorTestPreview)
            val typography = metadata.typographyList.map(::TypographyTestPreview)

            println("QQQ PROVIDE VALUES")
            println("QQQ" + metadata.toString())

            return components + colors + typography
        }
    }

    enum class BaseDeviceConfig(
        val deviceConfig: DeviceConfig,
    ) {
        NEXUS_5(DeviceConfig.NEXUS_5),
        PIXEL_C(DeviceConfig.PIXEL_C),
    }

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = 0.0,
    )

    @Test
    fun preview_tests(
        @TestParameter(valuesProvider = PreviewProvider::class) componentTestPreview: TestPreview,
        @TestParameter baseDeviceConfig: BaseDeviceConfig,
        @TestParameter(value = ["1.0", "1.5"]) fontScale: Float
    ) {
        println("QQQ SNAPSHOT")

        paparazzi.unsafeUpdateConfig(
            baseDeviceConfig.deviceConfig.copy(
                softButtons = false,
            )
        )
        paparazzi.snapshot {
            val lifecycleOwner = LocalLifecycleOwner.current
            CompositionLocalProvider(
                LocalInspectionMode provides true,
                LocalDensity provides Density(
                    density = LocalDensity.current.density,
                    fontScale = fontScale
                ),
                // Needed so that UI that uses it don't crash during screenshot tests
                LocalOnBackPressedDispatcherOwner provides object: OnBackPressedDispatcherOwner {
                    override fun getLifecycle() = lifecycleOwner.lifecycle

                    override fun getOnBackPressedDispatcher() = OnBackPressedDispatcher()
                }
            ) {
                Box {
                    componentTestPreview.Content()
                }
            }
        }
    }
}

interface TestPreview {
    @Composable
    fun Content()
}

class ComponentTestPreview(
    private val showkaseBrowserComponent: ShowkaseBrowserComponent
) : TestPreview {
    @Composable
    override fun Content() = showkaseBrowserComponent.component()
    override fun toString(): String = showkaseBrowserComponent.componentKey
}

class ColorTestPreview(
    private val showkaseBrowserColor: ShowkaseBrowserColor
) : TestPreview {
    @Composable
    override fun Content() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(showkaseBrowserColor.color)
        )
    }

    override fun toString(): String = "${showkaseBrowserColor.colorGroup}_${showkaseBrowserColor.colorName}"
}

class TypographyTestPreview(
    private val showkaseBrowserTypography: ShowkaseBrowserTypography
) : TestPreview {
    @Composable
    override fun Content() {
        BasicText(
            text = showkaseBrowserTypography.typographyName.replaceFirstChar {
                it.titlecase(Locale.getDefault())
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding4x),
            style = showkaseBrowserTypography.textStyle
        )
    }

    override fun toString(): String = "${showkaseBrowserTypography.typographyGroup}_${showkaseBrowserTypography.typographyName}"
}
