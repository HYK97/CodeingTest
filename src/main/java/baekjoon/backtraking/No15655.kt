package baekjoon.backtraking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { i -> i.toInt() }.toList()
    val list = br.readLine().split(" ").map { i -> i.toInt() }.toList().sorted()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val arrays = Array(m, { 0 })
    fun backTracking(index: Int) {
        if (index == m) {
            bw.write(arrays.joinToString(" "))
            bw.newLine()
            return
        }

        for (idx in index..<n) {
            if (index > 0 && arrays[index - 1] >= list[idx]) {
                continue
            }

            arrays[index] = list[idx]
            backTracking(index + 1)
        }

    }

    backTracking(0)

    bw.flush()
    bw.close()
}