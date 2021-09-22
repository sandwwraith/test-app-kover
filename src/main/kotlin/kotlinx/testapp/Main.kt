package kotlinx.testapp

class Main {
    fun helloWorld(): String = "Hello ${world()}!"

    fun greet(s: String) = "Hello $s!"

    inline fun world() = "world"

    fun goodbye(s: String) = "Goodbye, $s!"
}
