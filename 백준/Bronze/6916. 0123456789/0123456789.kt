import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val horizon0 = "\n"
    val horizon1 = " * * *\n"

    val verticalLeft = "*\n" +
            "*\n" +
            "*\n"
    val verticalRight = "      *\n" +
            "      *\n" +
            "      *\n"
    val verticalBoth = "*     *\n" +
            "*     *\n" +
            "*     *\n"

    val n = nextInt()
    when (n) {
        0, 2, 3, 5, 6, 7, 8, 9 -> print(horizon1)
        1, 4 -> print(horizon0)
    }
    when (n) {
        0, 4, 8, 9 -> print(verticalBoth)
        5, 6 -> print(verticalLeft)
        1, 2, 3, 7 -> print(verticalRight)
    }
    when (n) {
        0, 1, 7 -> print(horizon0)
        2, 3, 4, 5, 6, 8, 9 -> print(horizon1)
    }
    when (n) {
        0, 6, 8 -> print(verticalBoth)
        1, 3, 4, 5, 7, 9 -> print(verticalRight)
        2 -> print(verticalLeft)
    }
    when (n) {
        0, 2, 3, 5, 6, 8, 9 -> print(horizon1)
    }
}