package baekjoon.impl

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    var data = bufferedReader.readLine()
    val code = listOf(
        "dz=",
        "c-",
        "d-",
        "c=",
        "lj",
        "nj",
        "s=",
        "z="
    )
    for (datum in code) {
        data = data.replace(datum, "*")
    }

    println(data.length)
}