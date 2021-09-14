package kotlinx.testapp

import org.junit.Test

class Tests {
    @Test
    fun testHello() {
        val m = Main()
        assert(m.greet(m.world()).contains("world"))
    }
}
