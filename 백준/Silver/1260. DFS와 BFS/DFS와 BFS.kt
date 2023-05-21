import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var vertex = 0
val arr = Array(1001) { IntArray(1001) }
val dfsVisit = IntArray(1001)
val q: Queue<Int> = LinkedList()
val bfsVisit = IntArray(1001)

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val st = StringTokenizer(br.readLine(), " ")
    vertex = st.nextToken().toInt()
    val edge = st.nextToken().toInt()
    val start = st.nextToken().toInt()
    
    repeat(edge) {
        br.readLine().split(" ").map { it.toInt() }.let { (x, y) ->
            arr[x][y] = 1
            arr[y][x] = 1
        }
    }
    
    dfsVisit[start] = 1
    bfsVisit[start] = 1
    
    print("$start")
    dfs(start)
    print("\n")
    print("$start")
    q.add(start)
    bfs(start)
}

fun dfs(x: Int) {
    for (i in 1..vertex) {
        if (arr[x][i] == 1 && dfsVisit[i] == 0) {
            dfsVisit[i] = 1
            print(" $i")
            dfs(i)
        }
    }
}

fun bfs(x: Int) {
    while(q.isNotEmpty()) {
        val e = q.poll()
        for (i in 1..vertex) {
            if (arr[e][i] == 1 && bfsVisit[i] == 0) {
                bfsVisit[i] = 1
                print(" $i")
                q.add(i)
            }
        }
    }
}