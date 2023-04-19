import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val arr = Array(n) { br.readLine() }
    
    var result = 0

    arr.forEach {
        val appear = BooleanArray(123) { false }
        
        for (i in it.indices) {
            if (i > 0) {
                if (it[i - 1].code != it[i].code) {
                    if (appear[it[i].code]) {
                        return@forEach
                    }
                }
            }

            appear[it[i].code] = true
        }

        result++
    }
    
    bw.write("$result")
    bw.flush()
    bw.close()
    br.close()
}