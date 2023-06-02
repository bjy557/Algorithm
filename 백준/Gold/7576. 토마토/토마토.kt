import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine(), " ")
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    
    val arr = Array(m) { IntArray(n) }
    val days = Array(m) { IntArray(n) }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    
    for (i in 0 until m) {
        val temp = StringTokenizer(readLine(), " ");
        for (j in 0 until n) {
            arr[i][j] = temp.nextToken().toInt()
            if (arr[i][j] == 1) queue.add(Pair(i, j))
        }
    }
    
    var day = 0;
    while (queue.isNotEmpty()) {
        val pair = queue.poll()
        val i = pair.first
        val j = pair.second
        if (i-1 >= 0) {
            if (arr[i-1][j] == 0) {
                arr[i-1][j] = 1
                queue.add(Pair(i - 1, j))
                days[i-1][j] = days[i][j] + 1
            }
        }
        if (j-1 >= 0) {
            if (arr[i][j-1] == 0) {
                arr[i][j-1] = 1
                queue.add(Pair(i, j-1))
                days[i][j-1] = days[i][j] + 1
            }
        }
        if (i+1 < m) {
            if (arr[i+1][j] == 0) {
                arr[i+1][j] = 1
                queue.add(Pair(i+1, j))
                days[i+1][j] = days[i][j] + 1
            }
        }
        if (j+1 < n) {
            if (arr[i][j+1] == 0) {
                arr[i][j+1] = 1
                queue.add(Pair(i, j+1))
                days[i][j+1] = days[i][j] + 1
            }
        }
    }
    
    var maxValue = 0;
    
    loop@ for (i in 0 until m) {
        for (j in 0 until n) {
            if (arr[i][j] == 0) {
                maxValue = -1
                break@loop
            }
            maxValue = max(days[i][j], maxValue)
        }
    }
    
    print(maxValue)
}