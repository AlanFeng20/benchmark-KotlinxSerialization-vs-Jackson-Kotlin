object Test10 {
    val json: String = Test10::class.java.classLoader.getResourceAsStream("10.json").use {
        it.readBytes().decodeToString()
    }

}

fun main() {
    commonTest("Test10",Test10.json)
}