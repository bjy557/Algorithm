import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sum = IntArray(3)
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine(), " ")
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        val d = sum[0]
        val e = sum[1]
        val f = sum[2]
        sum[0] = min(a + e, a + f)
        sum[1] = min(b + d, b + f)
        sum[2] = min(c + d, c + e)
    }
    
    print(sum.min())
}