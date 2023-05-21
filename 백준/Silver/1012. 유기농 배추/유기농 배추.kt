import java.io.BufferedReader
import java.io.InputStreamReader

var arr = Array(50) { IntArray(50) }
var visit = Array(50) { IntArray(50) }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine().toInt()) {
        arr = Array(50) { IntArray(50) }
        visit = Array(50) { IntArray(50) }
        
        var resultCount = 0
        readLine().split(" ").map { it.toInt() }.let { (m, n, c) ->
            repeat(c) {
                readLine().split(" ").map { it.toInt() }.let { (x, y) -> arr[x][y] = 1 }
            }

            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (arr[i][j] == 1 && visit[i][j] == 0) {
                        resultCount++
                        dfs(i, j)
                    }
                }
            }
        }
        
        print("$resultCount\n")
    }
}

fun dfs(x: Int, y: Int) {
    visit[x][y] = 1
    if (x > 0) {
        if (arr[x-1][y] == 1 && visit[x-1][y] == 0) {
            dfs(x-1, y)
        }
    }
    if (y > 0) {
        if (arr[x][y-1] == 1 && visit[x][y-1] == 0) {
            dfs(x, y-1)
        }
    }
    if (x < 49) {
        if (arr[x+1][y] == 1 && visit[x+1][y] == 0) {
            dfs(x+1, y)
        }
    }
    if (y < 49) {
        if (arr[x][y+1] == 1 && visit[x][y+1] == 0) {
            dfs(x, y+1)
        }
    }
}