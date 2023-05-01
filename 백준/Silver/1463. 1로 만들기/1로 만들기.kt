import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val arr = IntArray(1000001)

    arr[1] = 0
    arr[2] = 1
    arr[3] = 1

    for (i in 4..n) {
        if (i % 6 == 0) {
            arr[i] = min(arr[i/2], min(arr[i/3], arr[i-1])) + 1
        } else if (i % 3 == 0) {
            arr[i] = min(arr[i/3], arr[i-1]) + 1
        } else if (i % 2 == 0) {
            arr[i] = min(arr[i/2], arr[i-1]) + 1
        } else {
            arr[i] = arr[i-1] + 1
        }
    }

    bw.write("${arr[n]}")
    bw.flush()
    bw.close()
    br.close()
}