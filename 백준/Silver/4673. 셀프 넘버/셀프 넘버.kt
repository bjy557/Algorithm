import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val arr = BooleanArray(10001) { true }
    var temp = 0
    for (i in 1..10000) {
        var n = i
        while (n > 0) {
            temp += n % 10
            n /= 10
        }
        if (i + temp <= 10000)
            arr[i + temp] = false
        
        temp = 0
    }
    for (i in 1..10000) {
        if (arr[i]) {
            bw.write("$i\n")
        }
    }
    
    bw.flush()
    bw.close()
}