/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package SpecialSync

import main.kotlin.SpecialSync.SyncHandler
import java.lang.StringBuilder
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class SyncHandlerTest {
    private val source = Paths.get(ClassLoader.getSystemClassLoader().getResource("in").toURI())
    private val output = Paths.get(ClassLoader.getSystemClassLoader().getResource("out").toURI())

    @BeforeTest
    fun setup() {
        //copy all contents from test_gold to the input directory
        Files.createFile(source.resolve("test_me"))
        Files.write(source.resolve("test_me"),StringBuilder("put some content into this file").toString().toByteArray())
        Files.createFile(source.resolve("empty_file"))

    }
    @AfterTest
    fun cleanup() {
        Files.delete(source.resolve("test_me"))
        Files.delete(source.resolve("empty_file"))

    }
    @Test fun testSyncHandler() {
        val classUnderTest = SyncHandler()

        classUnderTest.sync(source= source,destination= output)

    }
}
