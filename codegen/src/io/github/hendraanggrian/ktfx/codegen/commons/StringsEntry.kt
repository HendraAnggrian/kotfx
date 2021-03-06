package io.github.hendraanggrian.ktfx.codegen.commons

import io.github.hendraanggrian.kotlinpoet.parameterizedBy
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.LongBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.StringBinding

data class StringsEntry(
    val type: String,
    val functionName: String,
    val notNull: Boolean,
    val parameters: List<ParameterSpec>
) {

    val returnType: TypeName
        get() = when (type) {
            StringsFactory.BOOLEAN -> BooleanBinding::class.asTypeName()
            StringsFactory.DOUBLE -> DoubleBinding::class.asTypeName()
            StringsFactory.FLOAT -> FloatBinding::class.asTypeName()
            StringsFactory.INT -> IntegerBinding::class.asTypeName()
            StringsFactory.LONG -> LongBinding::class.asTypeName()
            StringsFactory.ANY -> ObjectBinding::class.parameterizedBy()
            StringsFactory.STRING -> StringBinding::class.asTypeName()
            else -> error("Unrecognizable type")
        }
}