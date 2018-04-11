@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import ktfx.layouts.internal.MarginedPane
import ktfx.layouts.internal.VGrowedPane

open class _VBox : VBox(), LayoutManager<Node>, VGrowedPane, MarginedPane {

    override val childs: ObservableList<Node> get() = children

    override fun Node.clear() = clearConstraints(this)

    override var Node.vpriority: Priority?
        get() = getVgrow(this)
        set(value) = setVgrow(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

inline fun vbox(): VBox = vbox { }

inline fun vbox(
    init: (@LayoutDsl _VBox).() -> Unit
): VBox = _VBox().apply(init)

inline fun LayoutManager<Node>.vbox(): VBox = vbox { }

inline fun LayoutManager<Node>.vbox(
    init: (@LayoutDsl _VBox).() -> Unit
): VBox = ktfx.layouts.vbox(init).add()