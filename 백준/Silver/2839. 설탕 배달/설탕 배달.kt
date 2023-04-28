import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    val div = n / 5
    val mod = n % 5

    var result = 0

    if (mod == 0) {
        result = div
    } else {
        for (i in div downTo 0) {
            val newMod = n - (5 * i)
            if (newMod % 3 == 0) {
                result = i + newMod / 3
                break
            }
        }

        if (result == 0) {
            if (n % 3 == 0) {
                result = n / 3
            } else {
                result = -1
            }
        }
    }

    bw.write("$result")
    bw.flush()
    bw.close()
    br.close()
}