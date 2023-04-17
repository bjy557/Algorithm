import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val n = br.readLine().toInt()
    val arr = IntArray(10001)
    repeat(n) {
        arr[br.readLine().toInt()]++
    }
    for (i in 1 .. 10000) {
        bw.write("$i\n".repeat(arr[i]))
    }
    bw.flush()
    bw.close()
}