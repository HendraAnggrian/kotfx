@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.StackPane
import ktfx.layouts.internal.AlignedPane
import ktfx.layouts.internal.MarginedPane

open class _StackPane : StackPane(), LayoutManager<Node>, AlignedPane, MarginedPane {

    override infix fun <N : Node> N.pos(value: Pos?): N = apply { setAlignment(this, value) }
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.pos: Pos get() = getAlignment(this) ?: Pos.TOP_LEFT
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun Node.reset() = clearConstraints(this)

    override fun <T : Node> T.add(): T = also { children += it }
}

inline fun stackPane(
    noinline init: ((@LayoutDsl _StackPane).() -> Unit)? = null
): StackPane = _StackPane().also { init?.invoke(it) }

inline fun LayoutManager<Node>.stackPane(
    noinline init: ((@LayoutDsl _StackPane).() -> Unit)? = null
): StackPane = ktfx.layouts.stackPane(init).add()