package co.tpcreative.qrcode_compose_multipleplatforms

import kotlin.random.Random

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun greets(): List<String> = buildList {
        add(if (Random.nextBoolean()) "Hi!" else "Hello!")
        add("Guess what this is! > ${platform.name.reversed()}!")
    }
}