import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val n = br.readLine().toInt()
    val arr = Array(n) { br.readLine() }
    
    run lit@{
        arr.forEach { cur ->
            val front = cur.substring(0 until cur.length / 2)
            val back = cur.substring(cur.length / 2 until cur.length).reversed()
            if (front == back) {
                bw.write("${cur.length} ${cur[cur.length / 2]}")
                return@lit
            }
            arr.forEach {
                if (cur == it.reversed()) {
                    bw.write("${cur.length} ${cur[cur.length / 2]}")
                    return@lit
                }
            }
        }
    }
    
    bw.flush()
    bw.close()
}