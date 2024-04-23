import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    var data = bufferedReader.readLine()
    val code = mapOf(
        Pair("c=", "c="),
        Pair("c-", "c-"),
        Pair("d-", "đ"),
        Pair("lj", "lj"),
        Pair("nj", "nj"),
        Pair("s=", "š"),
        Pair("z=", "ž")
    )
    data = data.replace("dz=", "*")
    for (datum in code.keys) {
        data =data.replace(datum,"*")
    }

    println(data.length)
}