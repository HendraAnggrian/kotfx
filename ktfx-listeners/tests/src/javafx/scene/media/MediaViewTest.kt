package ktfx.listeners

import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaView
import io.github.hendraanggrian.ktfx.test.BaseMediaViewTest

class MediaViewTest : BaseMediaViewTest() {

    override fun MediaView.callOnError(action: (MediaErrorEvent) -> Unit) = onError(action)
}