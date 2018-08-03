@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.shape.Box
import javafx.scene.shape.Box.DEFAULT_SIZE

/** Creates a [Box]. */
fun box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    init: ((@LayoutDsl Box).() -> Unit)? = null
): Box = Box(width, height, depth).also {
    init?.invoke(it)
}

/** Creates a [Box] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    noinline init: ((@LayoutDsl Box).() -> Unit)? = null
): Box = javafxx.layouts.box(width, height, depth, init)()

/** Create a styled [Box]. */
fun styledBox(
    styleClass: String,
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    init: ((@LayoutDsl Box).() -> Unit)? = null
): Box = Box(width, height, depth).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Box] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledBox(
    styleClass: String,
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    noinline init: ((@LayoutDsl Box).() -> Unit)? = null
): Box = javafxx.layouts.styledBox(styleClass, width, height, depth, init)()