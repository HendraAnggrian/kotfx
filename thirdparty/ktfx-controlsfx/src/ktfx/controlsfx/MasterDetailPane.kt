@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.controlsfx

import javafx.geometry.Side
import javafx.geometry.Side.RIGHT
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.MasterDetailPane

open class _MasterDetailPane(
    side: Side = RIGHT,
    showDetail: Boolean = true
) : MasterDetailPane(side, showDetail), LayoutManager<Node> {

    override fun <T : Node> T.invoke(): T = also {
        when (null) {
            masterNode -> masterNode = it
            detailNode -> detailNode = it
            else -> error("MasterDetailPane may only have 2 children")
        }
    }
}

/** Creates a [MasterDetailPane]. */
fun masterDetailPane(
    side: Side = RIGHT,
    showDetail: Boolean = true,
    init: ((@LayoutDsl _MasterDetailPane).() -> Unit)? = null
): MasterDetailPane = _MasterDetailPane(side, showDetail).also {
    init?.invoke(it)
}

/** Creates a [MasterDetailPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.masterDetailPane(
    side: Side = RIGHT,
    showDetail: Boolean = true,
    noinline init: ((@LayoutDsl _MasterDetailPane).() -> Unit)? = null
): MasterDetailPane = ktfx.controlsfx.masterDetailPane(side, showDetail, init)()