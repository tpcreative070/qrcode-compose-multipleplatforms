package co.tpcreative.qrcode

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform