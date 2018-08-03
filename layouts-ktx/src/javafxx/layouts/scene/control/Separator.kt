@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.Node
import javafx.scene.control.Separator

/** Creates a [Separator]. */
fun separator(
    orientation: Orientation = HORIZONTAL,
    init: ((@LayoutDsl Separator).() -> Unit)? = null
): Separator = Separator(orientation).also {
    init?.invoke(it)
}

/** Creates a [Separator] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.separator(
    orientation: Orientation = HORIZONTAL,
    noinline init: ((@LayoutDsl Separator).() -> Unit)? = null
): Separator = javafxx.layouts.separator(orientation, init)()

/** Create a styled [Separator]. */
fun styledSeparator(
    styleClass: String,
    orientation: Orientation = HORIZONTAL,
    init: ((@LayoutDsl Separator).() -> Unit)? = null
): Separator = Separator(orientation).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Separator] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledSeparator(
    styleClass: String,
    orientation: Orientation = HORIZONTAL,
    noinline init: ((@LayoutDsl Separator).() -> Unit)? = null
): Separator = javafxx.layouts.styledSeparator(styleClass, orientation, init)()