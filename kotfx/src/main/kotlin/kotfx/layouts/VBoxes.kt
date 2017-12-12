@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.Priority.NEVER
import javafx.scene.layout.VBox
import kotfx.internal.LayoutDsl

class _VBox : VBox(), VGrowable, Marginable {

    override infix fun Node.vgrow(priority: Priority) = setVgrow(this, priority)
    override val Node.vgrow2: Priority get() = getVgrow(this) ?: NEVER

    override infix fun Node.margin(insets: Insets) = setMargin(this, insets)
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun Node.removeConstraints() = clearConstraints(this)
}

inline fun vBox(init: (@LayoutDsl _VBox).() -> Unit): VBox = _VBox().apply(init)

inline fun Noded.vBox(init: (@LayoutDsl _VBox).() -> Unit): VBox = _VBox().apply(init).add()