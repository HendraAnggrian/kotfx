@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToolbar
import ktfx.layouts.KtfxLayoutDslMarker
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Configure [JFXToolbar] left items.
 * @param configuration the configuration block.
 */
inline fun JFXToolbar.leftItems(configuration: (@KtfxLayoutDslMarker KtfxJFXToolbar.HBoxConstraints).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    KtfxJFXToolbar.HBoxConstraints(leftItems).configuration()
}

/**
 * Configure [JFXToolbar] right items.
 * @param configuration the configuration block.
 */
inline fun JFXToolbar.rightItems(configuration: (@KtfxLayoutDslMarker KtfxJFXToolbar.HBoxConstraints).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    KtfxJFXToolbar.HBoxConstraints(rightItems).configuration()
}
