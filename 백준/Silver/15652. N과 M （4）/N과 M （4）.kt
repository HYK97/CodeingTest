import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (N, M) = br.readLine().split(" ").map(String::toInt)
    val array = Array(M, { 0 })
    fun backtracking(N: Int, M: Int, index: Int, prev: Int) {
        if (index == M) {
            for (i in array) {
                bw.write("$i ")
            }
            bw.newLine()
            return
        }
        for (i in 1..N) {
            if (prev > i) {
                continue
            }
            array[index] = i
            backtracking(N, M, index + 1, i)
        }
    }
    backtracking(N, M, 0, 1)
    bw.flush()
    bw.close()
}

