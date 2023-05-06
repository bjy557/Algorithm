import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n: Int = 0
var arr = Array(101) { IntArray(101) }
var visit = IntArray(101)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    n = br.readLine().toInt()
    
    repeat(br.readLine().toInt()) {
        val st = StringTokenizer(br.readLine(), " ")
        val f = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        arr[f][b] = 1
        arr[b][f] = 1
    }
    
    dfs(1)
    
    bw.write("${visit.sum() - 1}")
    
    bw.flush()
    bw.close()
    br.close()
}

fun dfs(x: Int) {
    for (i in 1..n) {
        if (arr[x][i] == 1 && visit[i] == 0) {
            visit[i] = 1
            dfs(i)
        }
    }
}