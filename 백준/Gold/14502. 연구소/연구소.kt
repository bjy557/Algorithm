import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

var n = 0
var m = 0
var max = 0
var wall = 0
var arr = Array(8) { IntArray(8) }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine(), " ")
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    for (i in 0 until n) {
        val st2 = StringTokenizer(readLine(), " ")
        for (j in 0 until m) {
            arr[i][j] = st2.nextToken().toInt()
        }
    }
    dfs()

    print(max)
}

fun dfs() {
    if (wall == 3) {
        bfs()
        return
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] == 0) {
                arr[i][j] = 1
                wall++
                dfs()
                arr[i][j] = 0
                wall--
            }
        }
    }
}

fun bfs() {
    var zeroCount = 0

    val queue = LinkedList<Pair<Int, Int>>()
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] == 2)
                queue.add(Pair(i, j))
        }
    }
    
    val copy = Array(8) { IntArray(8) }
    for (i in 0 until n) {
        copy[i] = arr[i].clone()
    }

    while (queue.isNotEmpty()) {
        val pair = queue.poll()
        val i = pair.first
        val j = pair.second

        if (i > 0) {
            if (copy[i - 1][j] == 0) {
                copy[i - 1][j] = 2
                queue.add(Pair(i - 1, j))
            }
        }

        if (j > 0) {
            if (copy[i][j - 1] == 0) {
                copy[i][j - 1] = 2
                queue.add(Pair(i, j - 1))
            }
        }

        if (i < n - 1) {
            if (copy[i + 1][j] == 0) {
                copy[i + 1][j] = 2
                queue.add(Pair(i + 1, j))
            }
        }

        if (j < m - 1) {
            if (copy[i][j + 1] == 0) {
                copy[i][j + 1] = 2
                queue.add(Pair(i, j + 1))
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (copy[i][j] == 0)
                zeroCount++
        }
    }

    max = max(max, zeroCount)
}