@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafx.geometry.Pos
import javafxx.styles.internal._GridPaneStyleBuilder

interface GridPaneStyleBuilder {

    var hgap: Number

    var vgap: Number

    var alignment: Pos

    var gridLinesVisible: Boolean
}

inline fun gridPaneStyle(
    prettyPrint: Boolean = false,
    builder: GridPaneStyleBuilder.() -> Unit
): String = _GridPaneStyleBuilder(prettyPrint).apply(builder).toString()