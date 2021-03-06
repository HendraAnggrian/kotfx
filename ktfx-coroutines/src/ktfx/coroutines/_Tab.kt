@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

package ktfx.coroutines

import javafx.event.Event
import javafx.scene.control.Tab
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see Tab.setOnSelectionChanged
 */
public fun Tab.onSelectionChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
) {
    return setOnSelectionChanged { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Tab.setOnClosed
 */
public fun Tab.onClosed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
) {
    return setOnClosed { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Tab.setOnCloseRequest
 */
public fun Tab.onCloseRequest(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
) {
    return setOnCloseRequest { event -> GlobalScope.launch(context) { action(event) } }
}
