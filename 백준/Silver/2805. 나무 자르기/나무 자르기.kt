import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st1 = StringTokenizer(readLine(), " ")
    val n = st1.nextToken().toInt()
    val m = st1.nextToken().toInt()

    var max = 0
    var min = 0
    val arr = IntArray(1000000)

    val st2 = StringTokenizer(readLine(), " ")

    for (i in 0 until n) {
        arr[i] = st2.nextToken().toInt()
        max = max(max, arr[i])
    }
    
    while(min <= max) {
        var half = (min + max) / 2
        if (half == min) {
            min = half
            break
        }
        var tree = 0L
        for (i in 0 until n) {
            if (arr[i] > half) {
                tree += (arr[i] - half)
            }
        }
        when {
            tree == m.toLong() -> {
                min = half
                break
            }
            tree < m.toLong() -> max = half
            tree > m.toLong() -> min = half
        }
    }
    
    print(min)
}