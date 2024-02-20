import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val up = BooleanArray(15)
    val diagonal1 = BooleanArray(29)
    val diagonal2 = BooleanArray(29)
    backtracking(N, up, diagonal1, diagonal2)


}

fun backtracking(N: Int, up: BooleanArray, diagonal1: BooleanArray, diagonal2: BooleanArray) {
    var count = 0
    fun recursion(x: Int) {
        if (x == N) {
            count++
            return
        }
        for (i in 0 until N) {
            if (up[i] || diagonal1[x + i] || diagonal2[x - i + N - 1]) {
                continue
            }
            up[i] = true
            diagonal1[x + i] = true
            diagonal2[x - i + N - 1] = true
            recursion(x + 1)
            up[i] = false
            diagonal1[x + i] = false
            diagonal2[x - i + N - 1] = false
        }
    }
    recursion(0)
    println(count)
}
