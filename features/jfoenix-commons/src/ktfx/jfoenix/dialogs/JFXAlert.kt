@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix.dialogs

import com.jfoenix.controls.JFXAlert
import java.util.Optional
import javafx.scene.Node
import javafx.scene.image.ImageView
import javafx.stage.Stage
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle

/**
 * Show a JFoenix alert with title and graphic.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param builderAction custom dialog builder action.
 * @return dialog result.
 */
fun <R> Stage.jfxAlert(
    title: String? = null,
    graphic: Node? = null,
    builderAction: (JFXAlert<R>.() -> Unit)? = null
): Optional<R> = JFXAlert<R>(this).also { dialog ->
    if (title != null) dialog.headerTitle = title
    when {
        graphic is ImageView -> dialog.graphicIcon = graphic
        graphic != null -> dialog.graphic = graphic
    }
    builderAction?.invoke(dialog)
}.showAndWait()

/**
 * Show an JFoenix alert.
 *
 * @param builderAction custom dialog builder action.
 * @return dialog result.
 */
inline fun <R> Stage.jfxAlert(
    noinline builderAction: (JFXAlert<R>.() -> Unit)? = null
): Optional<R> = jfxAlert(null, null, builderAction)