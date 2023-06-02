import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val input = br.readLine().toInt();
    
    for (i in 0 until input) {
        for (j in 0 until input) {
            star(i, j, input)
        }
        bw.write("\n")
    }
    
    bw.flush()
    bw.close()
    br.close()
}

fun star(i: Int, j: Int, input: Int) {
    if ((i / input) % 3 == 1 && (j / input) % 3 == 1) {
        bw.write(" ")
    } else {
        if (input / 3 == 0) {
            bw.write("*")
        } else {
            star(i, j, input / 3)
        }
    }
}