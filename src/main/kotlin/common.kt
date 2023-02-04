import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

val objectMapper = jacksonObjectMapper()

typealias Type=List<Model>

@OptIn(ExperimentalTime::class)
fun commonTest(name: String, json: String) {
    //warm up
    val warmJson = """[{
    "albumId": 1,
    "id": 8,
    "title": "aut porro officiis laborum odit ea laudantium corporis",
    "url": "https://via.placeholder.com/600/54176f",
    "thumbnailUrl": "https://via.placeholder.com/150/54176f"
  }]"""
    repeat(10000){
        objectMapper.readValue<Type>(warmJson)
        Json.decodeFromString<Type>(warmJson)
    }

    //startTest
    println("single")
    measureTime {
        Json.decodeFromString<Type>(json)
    }.also {
        println("$name,ktx:$it")
    }
    measureTime {
        objectMapper.readValue<Type>(json)
    }.also {
        println("$name,jacksonK:$it")
    }

    println("multi")

    val times = 10000
    measureTime {
        repeat(times){
            Json.decodeFromString<Type>(json)
        }
    }.also {
        println("$name,ktx:$it")
    }
    measureTime {
        repeat(times){
            objectMapper.readValue<Type>(json)
        }
    }.also {
        println("$name,jacksonK:$it")
    }
}