@file:Suppress("NOTHING_TO_INLINE")

package kotlinfx.animation

import javafx.animation.KeyFrame
import javafx.animation.Timeline

inline fun timelineOf(vararg keyFrames: KeyFrame): Timeline = Timeline(*keyFrames)