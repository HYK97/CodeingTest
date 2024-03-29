package baekjoon.impl

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numberOfQuestions = br.readLine().toInt()
    val query = mutableListOf<String>()

    for (q in 0 until numberOfQuestions) {
        query.add(br.readLine())
    }

    val initData = query.first().split(" ")

    val initNumber = initData[0]
    val initStrike = initData[1].toInt()
    val initBall = initData[2].toInt()

    val check = mutableSetOf<String>()
    val drawNumber = Array(3) { "-1" }
    val checkNumber = Array(10) { false }

    fun initDFS(index: Int) {
        if (index == 3) {
            val original = initNumber.split("").drop(1).dropLast(1)
            var sc = 0
            var bc = 0
            for (i in 0 until 3) {
                if (original[i] == drawNumber[i]) {
                    sc++;
                    continue
                }
                if (drawNumber.contains(original[i])) {
                    bc++;
                }
            }
            if (initStrike == sc && initBall == bc) {
                check.add(drawNumber[0] + drawNumber[1] + drawNumber[2])
            }
            return
        }

        for (i in 1..9) {
            if (drawNumber[index] != "-1" || checkNumber[i]) {
                continue
            }
            drawNumber[index] = i.toString()
            checkNumber[i] = true
            initDFS(index + 1)
            checkNumber[i] = false
            drawNumber[index] = "-1"
        }


    }

    initDFS(0)
    val removeSet = mutableSetOf<String>()
    for (q in query.drop(1)) {
        val split = q.split(" ")
        val strikeCount = split[1].toInt()
        val ballCount = split[2].toInt()
        val original = split[0].split("").drop(1).dropLast(1)

        for (c in check) {
            val checkNumber = c.split("").drop(1).dropLast(1)
            var sc = 0
            var bc = 0
            for (i in 0 until 3) {
                if (original[i] == checkNumber[i]) {
                    sc++;
                    continue
                }
                if (checkNumber.contains(original[i])) {
                    bc++;
                }
            }
            if (strikeCount != sc || ballCount != bc) {
                removeSet.add(c)
            }
        }
    }

    check.removeAll(removeSet)
    println(check.size)

}