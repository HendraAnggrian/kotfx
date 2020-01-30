@file:JvmMultifileClass
@file:JvmName("RegionKt")

package ktfx.controls

import javafx.geometry.Insets
import javafx.scene.image.Image
import javafx.scene.layout.Border
import javafx.scene.layout.BorderImage
import javafx.scene.layout.BorderRepeat
import javafx.scene.layout.BorderStroke
import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.layout.BorderWidths
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.Region
import javafx.scene.paint.Paint
import kotlin.DeprecationLevel.ERROR
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter

/** Create multiple [BorderStroke] and/or [BorderImage] using DSL. */
inline fun buildBorder(builder: BorderBuilder.() -> Unit): Border =
    BorderBuilder().apply(builder).build()

/** Add multiple [BorderStroke] and/or [BorderImage] to node using DSL. */
inline fun Region.border(builder: BorderBuilder.() -> Unit): Border =
    buildBorder(builder).also { border = it }

/** Add a new [BorderStroke] to node using DSL. */
inline fun Region.borderStroke(strokeBuilder: BorderBuilder.StrokeBuilder.() -> Unit): Border =
    border { stroke(strokeBuilder) }

/** Add a new [BorderImage] to node using DSL. */
inline fun Region.borderImage(image: Image, imageBuilder: BorderBuilder.ImageBuilder.() -> Unit): Border =
    border { image(image, imageBuilder) }

/**
 * Class to support adding [Border] to node with DSL.
 *
 * @see Region.border
 */
class BorderBuilder @PublishedApi internal constructor() {
    val strokes: MutableList<BorderStroke> = mutableListOf()
    val images: MutableList<BorderImage> = mutableListOf()

    /** Add a new [BorderStroke] to node using DSL. */
    inline fun stroke(strokeBuilder: StrokeBuilder.() -> Unit): BorderStroke =
        StrokeBuilder().apply(strokeBuilder).build().also { strokes += it }

    /** Add a new [BorderImage] to node using DSL. */
    inline fun image(image: Image, imageBuilder: ImageBuilder.() -> Unit): BorderImage =
        ImageBuilder(image).apply(imageBuilder).build().also { images += it }

    @PublishedApi internal fun build(): Border = Border(strokes, images)

    /**
     * Class to support adding [BorderStroke] stroke to node with DSL.
     *
     * @see BorderBuilder.stroke
     */
    class StrokeBuilder @PublishedApi internal constructor() {
        /** The fill to use on the top. If null, defaults to [javafx.scene.paint.Color.BLACK]. */
        var topStroke: Paint? = null

        /** The fill to use on the right. If null, defaults to the same value as [topStroke]. */
        var rightStroke: Paint? = null

        /** The fill to use on the bottom. If null, defaults to the same value as [bottomStroke]. */
        var bottomStroke: Paint? = null

        /** The fill to use on the left. If null, defaults to the same value as [rightStroke]. */
        var leftStroke: Paint? = null

        /** The stroke to use for all sides. If null, we default to [javafx.scene.paint.Color.BLACK]. */
        var stroke: Paint?
            @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
            set(value) {
                topStroke = value; rightStroke = value; bottomStroke = value; leftStroke = value
            }

        /** The style to use on the top. If null, defaults to [BorderStrokeStyle.NONE]. */
        var topStyle: BorderStrokeStyle? = null

        /** The style to use on the right. If null, defaults to the same value as [topStyle]. */
        var rightStyle: BorderStrokeStyle? = null

        /** The style to use on the bottom. If null, defaults to the same value as [topStyle]. */
        var bottomStyle: BorderStrokeStyle? = null

        /** The style to use on the left. If null, defaults to the same value as [rightStyle]. */
        var leftStyle: BorderStrokeStyle? = null

        /** The style to use for all sides. If null, we default to [BorderStrokeStyle.NONE]. */
        var style: BorderStrokeStyle?
            @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
            set(value) {
                topStyle = value; rightStyle = value; bottomStyle = value; leftStyle = value
            }

        /** The radii. If null, we default to square corners by using [CornerRadii.EMPTY]. */
        var radii: CornerRadii? = null

        /** The thickness of each side. If null, we default to [BorderWidths.DEFAULT]. */
        var widths: BorderWidths? = null

        /** The insets indicating where to draw the border relative to the region edges. */
        var insets: Insets? = null

        @PublishedApi internal fun build(): BorderStroke = BorderStroke(
            topStroke, rightStroke, bottomStroke, leftStroke,
            topStyle, rightStyle, bottomStyle, leftStyle,
            radii, widths, insets
        )
    }

    /**
     * Class to support adding [BorderImage] to node with DSL.
     *
     * @param image the image to use as border.
     * @see BorderBuilder.image
     */
    class ImageBuilder @PublishedApi internal constructor(private val image: Image) {
        /** The widths of the border in each dimension. A null value results in [BorderWidths.EMPTY]. */
        var widths: BorderWidths? = null

        /** The insets at which to place the border relative to the region. A null value results in [Insets.EMPTY]. */
        var insets: Insets? = null

        /** The slices for the image. If null, defaults to [BorderWidths.DEFAULT]. */
        var slices: BorderWidths? = null

        var isFill: Boolean = false

        /** The repeat value for the border image in the x direction. If null, defaults to [BorderRepeat.STRETCH]. */
        var repeatX: BorderRepeat? = null

        /** The repeat value for the border image in the y direction. If null, defaults to the same value as repeatX. */
        var repeatY: BorderRepeat? = null

        /** The repeat value for the border image in the x and y direction. If null, defaults to [BorderRepeat.STRETCH]. */
        var repeat: BorderRepeat?
            @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
            set(value) {
                repeatX = value; repeatY = value
            }

        @PublishedApi internal fun build(): BorderImage =
            BorderImage(image, widths, insets, slices, isFill, repeatX, repeatY)
    }
}