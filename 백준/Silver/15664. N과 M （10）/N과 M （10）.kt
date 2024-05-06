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
    val set = LinkedHashSet<String>()
    val check = Array(n, { false })
    val result = Array(m, { 0 })

    fun backTracking(index: Int) {
        if (index == m) {
            set.add(result.joinToString(" "))
            return
        }

        for (i in index until n) {
            if (check[i]) {
                continue
            }
            if (index > 0 && result[index - 1] > data[i]) {
                continue
            }
            result[index] = data[i]
            check[i] = true
            backTracking(index + 1)
            check[i] = false
        }

    }
    backTracking(0)

    for (item in set) {
        bw.write(item)
        bw.newLine()
    }

    bw.flush()
    bw.close()

}