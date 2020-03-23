package ktfx

import java.util.concurrent.Callable
import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.ObjectBinding
import javafx.util.Callback

/** Create new callback using Kotlin function type. */
inline fun <P, R> callbackOf(crossinline callback: (P) -> R?): Callback<P, R> = Callback { callback(it) }

/** Create an [ObjectBinding] of [Callback] with multiple [Observable] dependencies. */
inline fun <P, R> callbackBindingOf(
    vararg dependencies: Observable,
    crossinline valueProvider: (P) -> R?
): ObjectBinding<Callback<P, R>> =
    Bindings.createObjectBinding(Callable { Callback<P, R> { valueProvider(it) } }, *dependencies)

/** Converts the object provided into its string form. */
@Suppress("NOTHING_TO_INLINE")
inline operator fun <P, R> Callback<P, R>.invoke(obj: P): R = call(obj)