package co.tpcreative.qrcode_compose_multipleplatforms

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}