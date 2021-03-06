package io.github.hendraanggrian.ktfx.rules

import io.github.hendraanggrian.ktfx.test.RuleTest
import kotlin.test.Test

class PredefinedPackageRuleTest : RuleTest {
    override val rule = PredefinedPackageRule()

    @Test fun correct() = assertRule {
        """
            package ktfx.coroutines
        """
    }

    @Test fun wrong() = assertRule(
        lintErrorOf(1, 9, "Illegal package name.")
    ) {
        """
            package ktfx.coroutiness
        """
    }
}