package baekjoon.backtraking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { i -> i.toInt() }
    val data = br.readLine().split(" ").map { i -> i.toInt() }.sorted()

    val result = Array(m, { 0 })
    fun backTracking(index: Int) {
        if (index == m) {
            bw.write(result.joinToString(" "))
            bw.newLine()
            return
        }
        for (datum in data) {
            result[index] = datum
            backTracking(index + 1)
        }
    }

    backTracking(0)
    bw.flush()
    bw.close()


}