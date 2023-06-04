import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.system.exitProcess

val arr = Array(9) { IntArray(9) }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    for (i in 0 until 9) {
        val st = StringTokenizer(readLine(), " ")
        for (j in 0 until 9) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    dfs(0, 0)
}

fun dfs(i: Int, j: Int) {
    if (j == 9) {
        dfs(i + 1, 0)
        return
    }

    if (i == 9) {
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                print("${arr[i][j]} ")
            }
            print("\n")
        }
        exitProcess(0)
    }

    if (arr[i][j] == 0) {
        for (k in 1..9) {
            if (isValid(i, j, k)) {
                arr[i][j] = k
                dfs(i, j+1)
            }
        }
        
        arr[i][j] = 0
        return
    }

    dfs(i, j + 1)
}

fun isValid(i: Int, j: Int, k: Int): Boolean {
    for (tmp in 0 until 9) {
        if (arr[i][tmp] == k) return false // check row
        if (arr[tmp][j] == k) return false // check col
    }

    for (x in i / 3 * 3 until i / 3 * 3 + 3) {
        for (y in j / 3 * 3 until j / 3 * 3 + 3) {
            if (arr[x][y] == k) return false
        }
    }

    return true
}
