import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger
import java.util.*
import kotlin.math.max

val arr = IntArray(1000000)
var min = 0
var n = 0
var m = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st1 = StringTokenizer(readLine(), " ")
    n = st1.nextToken().toInt()
    m = st1.nextToken().toInt()

    var max = 0

    val st2 = StringTokenizer(readLine(), " ")

    for (i in 0 until n) {
        arr[i] = st2.nextToken().toInt()
        max = max(max, arr[i])
    }

    findValue(max, 0)
    
    print(min)
}

fun findValue(x: Int, y: Int) {
    val half = (x + y) / 2
    if (half == y) {
        min = half
    } else {
        var tree = BigInteger("0")
        for (i in 0 until n) {
            if (arr[i] >= half) {
                tree += (arr[i] - half).toBigInteger()
            }
        }
        when {
            tree == m.toBigInteger() -> min = half
            tree < m.toBigInteger() -> findValue(half, y)
            tree > m.toBigInteger() -> findValue(x, half)
        }
    }
}