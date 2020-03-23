@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRippler
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import ktfx.layouts.NodeManager

/**
 * [JFXRippler] with dynamic-layout dsl support.
 * Invoking dsl will only set its children.
 */
open class KtfxJFXRippler : JFXRippler(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { control = it }
}