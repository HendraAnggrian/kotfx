package ktfx.layouts.scene.control

import javafx.scene.control.TextArea
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.textArea
import ktfx.test.LayoutTest
import kotlin.test.assertEquals

class TextAreaTest : LayoutTest<NodeManager, TextArea>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = textArea { }
    override fun NodeManager.child2() = textArea()
    override fun NodeManager.child3() = textArea { }

    override fun TextArea.testDefaultValues() {
        assertEquals("", text)
    }
}