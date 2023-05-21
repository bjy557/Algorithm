import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(br.readLine().toInt()) {
        val st = StringTokenizer(br.readLine(), " ")
        val x1 = st.nextToken().toInt()
        val y1 = st.nextToken().toInt()
        val r1 = st.nextToken().toInt()
        val x2 = st.nextToken().toInt()
        val y2 = st.nextToken().toInt()
        val r2 = st.nextToken().toInt()
        val d1 = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)
        val d2 = (r1 + r2) * (r1 + r2)
        val d3 = (r1 - r2) * (r1 - r2)

        when {
            d1 == 0 && r1 == r2 -> bw.write("-1\n")
            (d1 == 0 && r1 != r2) || d1 > d2 || d1 < d3 -> bw.write("0\n")
            d1 == d2 || d1 == d3 -> bw.write("1\n")
            d1 < d2 || d1 > d3 -> bw.write("2\n")
        }
    }

    bw.flush()
    bw.close()
    br.close()
}