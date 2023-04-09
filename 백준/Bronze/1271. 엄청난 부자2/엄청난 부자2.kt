import java.util.Scanner

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val a = nextBigInteger()
    val b = nextBigInteger()
    println(a / b)
    println(a % b)
}