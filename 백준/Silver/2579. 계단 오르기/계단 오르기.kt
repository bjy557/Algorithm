import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    when (n) {
        1 -> bw.write("${br.readLine().toInt()}")
        2 -> bw.write("${br.readLine().toInt() + br.readLine().toInt()}")
        else -> {
            val arr = IntArray(n) { br.readLine().toInt() }
            val resArr = IntArray(n)

            resArr[0] = arr[0]
            resArr[1] = arr[0] + arr[1]
            resArr[2] = max(arr[0] + arr[2], arr[1] + arr[2])

            for (i in 3 until n) {
                resArr[i] = max(arr[i] + resArr[i - 2], arr[i] + arr[i - 1] + resArr[i - 3])
            }

            bw.write("${resArr[n - 1]}")
        }
    }

    bw.flush()
    bw.close()
    br.close()
}