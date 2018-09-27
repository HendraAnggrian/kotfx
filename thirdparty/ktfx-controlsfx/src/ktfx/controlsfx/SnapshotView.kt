@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.SnapshotView

/** Creates a [SnapshotView]. */
fun snapshotView(
    node: Node? = null,
    init: ((@LayoutDsl SnapshotView).() -> Unit)? = null
): SnapshotView = SnapshotView(node).also {
    init?.invoke(it)
}

/** Creates a [SnapshotView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.snapshotView(
    node: Node? = null,
    noinline init: ((@LayoutDsl SnapshotView).() -> Unit)? = null
): SnapshotView = ktfx.controlsfx.snapshotView(node, init)()