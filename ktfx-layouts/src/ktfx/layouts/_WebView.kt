@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.web.WebView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [WebView] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.webView(): WebView = webView() { }

/**
 * Create a [WebView] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun webView(configuration: (@KtfxLayoutDslMarker WebView).() -> Unit): WebView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = WebView()
    child.configuration()
    return child
}

/**
 * Add a [WebView] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.webView(configuration: (@KtfxLayoutDslMarker WebView).() -> Unit):
    WebView {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = WebView()
        child.configuration()
        return addChild(child)
    }

/**
 * Create a styled [WebView].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledWebView(vararg styleClass: String, id: String? = null): WebView =
    styledWebView(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [WebView] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledWebView(vararg styleClass: String, id: String? = null): WebView =
    styledWebView(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [WebView] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledWebView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker WebView).() -> Unit
): WebView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = WebView()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [WebView] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledWebView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker WebView).() -> Unit
): WebView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = WebView()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
