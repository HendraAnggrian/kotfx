@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafxx.styles.internal._XYChartStyleBuilder

interface XYChartStyleBuilder {

    var alternativeColumnFillVisible: Boolean

    var alternativeRowFillVisible: Boolean

    var horizontalGridLinesVisible: Boolean

    var horizontalZeroLineVisible: Boolean

    var verticalGridLinesVisible: Boolean

    var verticalZeroLineVisible: Boolean
}

inline fun xyChartStyle(
    prettyPrint: Boolean = false,
    builder: XYChartStyleBuilder.() -> Unit
): String = _XYChartStyleBuilder(prettyPrint).apply(builder).toString()