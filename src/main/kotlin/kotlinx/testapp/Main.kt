package kotlinx.testapp

class Main {
    fun newFun() = 2 + 2

    fun helloWorld(): String = "Hello ${world()}!"

    fun greet(s: String) = "Hello $s!"

    inline fun world() = "world"
}
