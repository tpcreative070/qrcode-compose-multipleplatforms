package co.tpcreative.qrcode_compose_multipleplatforms

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform