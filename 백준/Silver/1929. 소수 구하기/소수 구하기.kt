import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val st = br.readLine().split(" ")
    val m = st[0].toInt()
    val n = st[1].toInt()
    val arr = BooleanArray(1000001) { true }
    arr[1] = false

    for (i in 2..500000) {
        for (j in 2..500000) {
            val mul = i * j
            if (mul > 1000000) {
                break
            }
            arr[mul] = false
        }
    }

    for (i in m..n) {
        if (arr[i]) {
            bw.write("$i\n")
        }
    }
    bw.flush()
    bw.close()
    br.close()
}