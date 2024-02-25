import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val readLine = br.readLine().split(" ")
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = readLine[0].toInt()
    val M = readLine[1].toInt()
    val list = LinkedList<Int>()
    fun backtracking(N: Int, M: Int, index: Int) {
        if (index == M) {
            bw.write(list.joinToString(separator = " ")+"\n")
            return
        }
        for (i in 1..N) {
            list.addLast(i)
            backtracking(N, M, index + 1)
            list.pollLast()
        }
    }
    backtracking(N, M, 0)
    bw.flush()
    bw.close()
}
