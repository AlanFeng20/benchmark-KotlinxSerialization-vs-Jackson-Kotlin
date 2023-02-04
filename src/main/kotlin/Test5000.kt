object Test5000 {
    val json: String = Test5000::class.java.classLoader.getResourceAsStream("5000.json").use {
        it.readBytes().decodeToString()
    }

}

fun main() {

    commonTest("Test5000",Test5000.json)
}