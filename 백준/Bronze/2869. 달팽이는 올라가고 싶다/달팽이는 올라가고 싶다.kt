import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*

fun main() {
    val st = StringTokenizer(readln(), " ")
    val a = st.nextToken().toBigDecimal()
    val b = st.nextToken().toBigDecimal()
    val v = st.nextToken().toBigDecimal()
    println((v - a).divide((a - b), 0, RoundingMode.CEILING) + BigDecimal.ONE)
}