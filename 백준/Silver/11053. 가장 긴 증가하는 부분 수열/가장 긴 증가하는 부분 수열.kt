import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

val arr = IntArray(1001)
val res = IntArray(1001)
var max = 1

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine(), " ")
    for (i in 1..n) {
        arr[i] = st.nextToken().toInt()
    }

    res[1] = 1

    for (i in 2..n) {
        res[i] = 1
        for (j in i - 1 downTo 1) {
            if (arr[j] < arr[i]) {
                res[i] = max(res[i], res[j] + 1)
                max = max(max, res[i])
            }
        }
    }
    
    print(max)
}