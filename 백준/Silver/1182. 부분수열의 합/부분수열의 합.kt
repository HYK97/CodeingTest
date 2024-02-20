import java.io.BufferedReader
import java.io.InputStreamReader

var result = 0
var n: Int = 0
var s: Int = 0
lateinit var data: List<Int>
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val split = br.readLine().split(" ")
    n = split[0].toInt()
    s = split[1].toInt()
    data = br.readLine().split(" ").map(String::toInt)
    backtracking(0, 0)

    if (s == 0) {
        print(result - 1)
    } else {
        print(result)
    }

}

fun backtracking(index: Int, sum: Int) {
    if (index == n) {
        if (sum == s) {
            result++
        }
        return
    }

    backtracking(index + 1, data[index] + sum)
    backtracking(index + 1, sum)

}