plugins {
    kotlin("jvm")
}

sourceSets {
    getByName("main") {
        java.srcDir("src")
    }
}

dependencies {
    api(kotlin("stdlib", VERSION_KOTLIN))
    api(kotlin("test-junit", VERSION_KOTLIN))
    api(google("truth", "truth", VERSION_TRUTH))

    api(testFx("testfx-junit", VERSION_TESTFX))
    api(testFx("openjfx-monocle", VERSION_MONOCLE))
    api(junit())
}