import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val a = Array(n) { nextInt() }
    val b = nextInt()
    val c = nextInt()
    var result = 0L
    a.forEach {
        result +=
            if (b >= it)
                1L
            else
                ((it - b) / c + (if ((it - b) % c == 0) 1 else 2)).toLong()
    }
    println(result)
}