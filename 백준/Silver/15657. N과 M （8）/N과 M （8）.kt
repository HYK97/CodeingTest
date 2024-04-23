package baekjoon.backtraking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


/**
 * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.
 *
 * N개의 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 고른 수열은 비내림차순이어야 한다.
 * 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
 *
 *
 *
 * */
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

        for (i in 0..<n) {
            if (index > 0 && data[i] != result[index - 1] && data[i] < result[index - 1]) {
                continue
            }
            result[index] = data[i]
            backTracking(index + 1)
        }

    }
    backTracking(0)
    bw.flush()
    bw.close()

}