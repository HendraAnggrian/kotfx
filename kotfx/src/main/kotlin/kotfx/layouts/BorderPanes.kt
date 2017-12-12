@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.geometry.Pos
import javafx.geometry.Pos.TOP_LEFT
import javafx.scene.Node
import javafx.scene.layout.BorderPane
import kotfx.internal.LayoutDsl

class _BorderPane : BorderPane(), Alignable, Marginable {

    override infix fun Node.align(pos: Pos) = setAlignment(this, pos)
    override val Node.align: Pos get() = getAlignment(this) ?: TOP_LEFT

    override infix fun Node.margin(insets: Insets) = setMargin(this, insets)
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun Node.removeConstraints() = clearConstraints(this)
}

inline fun borderPane(init: (@LayoutDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init)

inline fun Noded.borderPane(init: (@LayoutDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init).add()