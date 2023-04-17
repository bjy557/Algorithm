import java.util.*

fun main() {
    val t = StringTokenizer(readln())
    val a = t.nextToken().toInt()
    val b = t.nextToken().toInt()
    val c = t.nextToken().toInt()
    if (b >= c)
        println(-1)
    else
        println(a / (c - b) + 1)
}
