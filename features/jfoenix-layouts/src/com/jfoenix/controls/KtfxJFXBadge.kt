@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXBadge
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import ktfx.layouts.NodeManager

/**
 * [JFXBadge] with dynamic-layout dsl support.
 * Invoking dsl will only set its control.
 */
open class KtfxJFXBadge : JFXBadge(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { control = it }
}