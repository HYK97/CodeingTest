package baekjoon.backtraking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (N, M) = br.readLine().split(" ").map(String::toInt)
    val map = br.readLine().split(" ").map(String::toInt).sorted()
    val check = Array(N, { false })
    val array = Array(M, { 0 })

    fun backtracking(index: Int) {
        if (index == M) {
            bw.write(array.joinToString(separator = " "))
            bw.newLine()
            return
        }

        for (i in 0..<N) {
            if (check[i]) {
                continue
            }
            check[i]=true
            array[index]=map[i]
            backtracking(index+1)
            check[i]=false
        }

    }
    backtracking(0)
    bw.flush()
    bw.close()
}