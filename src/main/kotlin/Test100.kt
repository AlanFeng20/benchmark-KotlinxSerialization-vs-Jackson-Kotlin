object Test100 {
    val json: String = Test100::class.java.classLoader.getResourceAsStream("100.json").use {
        it.readBytes().decodeToString()
    }

}

fun main() {

    commonTest("Test100",Test100.json)
}