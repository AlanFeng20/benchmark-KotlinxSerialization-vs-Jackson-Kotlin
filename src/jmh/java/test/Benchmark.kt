package test

import Model
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.annotations.Benchmark
import java.util.concurrent.TimeUnit


@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
open class Benchmark {

    @Param("10", "100", "5000")
    var jsonArrayLength: Int = 0
    lateinit var json:String

    @Setup
    fun setup() {
        json = Benchmark::class.java.classLoader.getResourceAsStream("$jsonArrayLength.json").use {
            it.readBytes().decodeToString()
        }
    }

    @Benchmark
    fun ktx() {
        Json.decodeFromString<List<Model>>(json)
    }
    val objectMapping=jacksonObjectMapper()
    @Benchmark
    fun jackson() {
        objectMapping.readValue<List<Model>>(json)
    }
}