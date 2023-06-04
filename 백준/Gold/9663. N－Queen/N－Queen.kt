import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

var n = 0
var count = 0
val visit = IntArray(14)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()

    dfs(0)

    print(count)
}

fun dfs(put: Int) {
    if (put == n) {
        count++
        return
    }

    for (i in 1..n) {
        if (put > 0) {
            if (check(i, put)) {
                continue
            }
        }

        visit[put] = i
        dfs(put + 1)
        visit[put] = 0
    }
}

fun check(i: Int, put: Int): Boolean {
    for (j in 0 until put) {
        if (i == visit[j] || abs(i - visit[j]) == put - j)
            return true
    }

    return false
}