@file:JvmMultifileClass
@file:JvmName("EventsKt")

package kotfx.coroutines

import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun MediaPlayer.onMarker(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MediaMarkerEvent) -> Unit
) = setOnMarker { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun MediaView.onError(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MediaErrorEvent) -> Unit
) = setOnError { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}