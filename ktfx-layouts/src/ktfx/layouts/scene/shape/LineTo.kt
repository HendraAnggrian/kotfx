@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.LineTo

/** Creates a [LineTo]. */
fun lineTo(
    x: Double = 0.0,
    y: Double = 0.0,
    init: ((@LayoutMarker LineTo).() -> Unit)? = null
): LineTo = LineTo(x, y).also { init?.invoke(it) }

/** Creates a [LineTo] and add it to this manager. */
inline fun PathElementInvokable.lineTo(
    x: Double = 0.0,
    y: Double = 0.0,
    noinline init: ((@LayoutMarker LineTo).() -> Unit)? = null
): LineTo = ktfx.layouts.lineTo(x, y, init)()