@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.binding.Bindings.floatValueAt
import javafx.beans.binding.Bindings.integerValueAt
import javafx.beans.binding.Bindings.size
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableNumberValue
import javafx.collections.ObservableArray
import javafx.collections.ObservableFloatArray
import javafx.collections.ObservableIntegerArray

inline val ObservableArray<*>.sizeBinding: IntegerBinding get() = size(this)

inline fun ObservableFloatArray.floatValueAt(index: Int): FloatBinding = floatValueAt(this, index)
inline fun ObservableFloatArray.floatValueAt(index: ObservableIntegerValue): FloatBinding = floatValueAt(this, index)
inline fun ObservableFloatArray.floatValueAt(index: ObservableNumberValue): FloatBinding = floatValueAt(this, index)

inline fun ObservableIntegerArray.intValueAt(index: Int): IntegerBinding = integerValueAt(this, index)
inline fun ObservableIntegerArray.intValueAt(index: ObservableIntegerValue): IntegerBinding = integerValueAt(this, index)
inline fun ObservableIntegerArray.intValueAt(index: ObservableNumberValue): IntegerBinding = integerValueAt(this, index)