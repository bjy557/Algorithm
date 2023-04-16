fun main() {
    var decimal = 0L

    while(true) {
        val line = readLine() ?: break
        val trim = line.trim().split(".")
        decimal += trim[0].toLong() * 100 + trim[1].toLong()
    }

    val x = decimal / 100
    val y = decimal % 100

    println("${x}.${if (y < 10) "0$y" else "$y"}")
}
