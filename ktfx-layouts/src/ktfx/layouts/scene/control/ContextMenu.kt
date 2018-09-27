@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName", "UsePropertyAccessSyntax")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.ContextMenu
import javafx.scene.control.Control
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TableColumnBase

open class _ContextMenu(
    vararg items: MenuItem
) : ContextMenu(*items), LayoutManager<MenuItem> {

    override val childs: MutableCollection<MenuItem> get() = items

    /** Creates a [MenuItem] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null
    ): MenuItem = menuItem(this, graphic, init)
}

/** Creates a [ContextMenu]. */
fun contextMenu(
    vararg items: MenuItem,
    init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null
): ContextMenu = _ContextMenu(*items).also {
    init?.invoke(it)
}

/** Creates a [ContextMenu] and set it to this [Control]. */
inline fun Control.contextMenu(
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null
): ContextMenu = ktfx.layouts.contextMenu(*items, init = init).also { setContextMenu(it) }

/** Creates a [ContextMenu] and set it to this [Tab]. */
inline fun Tab.contextMenu(
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null
): ContextMenu = ktfx.layouts.contextMenu(*items, init = init).also { setContextMenu(it) }

/** Creates a [ContextMenu] and set it to this [TableColumnBase]. */
inline fun <S, T> TableColumnBase<S, T>.contextMenu(
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null
): ContextMenu = ktfx.layouts.contextMenu(*items, init = init).also { setContextMenu(it) }