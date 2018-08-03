@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafxx.styles.internal._NumberAxisStyleBuilder

interface NumberAxisStyleBuilder {

    /** The value between each major tick mark in data units. */
    var tickUnit: Number
}

inline fun numberAxisStyle(
    prettyPrint: Boolean = false,
    builder: NumberAxisStyleBuilder.() -> Unit
): String = _NumberAxisStyleBuilder(prettyPrint).apply(builder).toString()