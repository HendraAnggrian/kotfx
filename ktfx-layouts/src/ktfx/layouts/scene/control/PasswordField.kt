@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.PasswordField

/** Creates a [PasswordField]. */
fun passwordField(
    init: ((@LayoutDsl PasswordField).() -> Unit)? = null
): PasswordField = PasswordField().also {
    init?.invoke(it)
}

/** Creates a [PasswordField] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.passwordField(
    noinline init: ((@LayoutDsl PasswordField).() -> Unit)? = null
): PasswordField = ktfx.layouts.passwordField(init)()