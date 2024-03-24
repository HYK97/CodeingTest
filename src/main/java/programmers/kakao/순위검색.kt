package programmers.kakao

import kotlin.collections.ArrayList


fun main() {

    Solution2().solution(
        arrayOf(
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50"
        ),
        arrayOf("- and - and - and - 150")
    )
}

//cpp, java, python 중 하나를 선택해야 합니다.4
//지원 직군 항목에 backend와 frontend 2
//지원 경력구분 항목에 junior와 senior 2
//선호하는 소울푸드로 chicken과 pizza 2
//코딩 테스트 점수 (x)
//시간 초과

fun solution(info: Array<String>, query: Array<String>): IntArray {

    val list = ArrayList<Pair<String, String>>()

    for (s in info) {
        val split = s.split(" ")
        list.add(Pair(split[0] + " " + split[1] + " " + split[2] + " " + split[3], split[4]))
    }
    val countList = ArrayList<Int>()

    for (s in query) {
        val split = s.replace("and ", "").split(" ")
        val score = split[4]
        var count = 0
        for (pair in list) {
            if (score.toInt() <= pair.second.toInt()) {
                val split1 = pair.first.split(" ")
                val split2 = s.replace("and ", "").split(" ")
                var data = true
                for (index in split1.indices) {
                    if (split2[index] != "-" && split1[index] != split2[index]) {
                        data = false
                        break
                    }
                }
                if (data) {
                    count++
                }
            }
        }
        countList.add(count)
    }

    return countList.toIntArray()
}

//이진 검색
//dfs 모든 쿼리

class Solution2 {

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val table = LinkedHashMap<String, ArrayList<Int>>()

        info.forEach { data ->
            val tokens = data.split(" ")
            bruteForce(table, tokens, tokens.last().toInt(), "", 0)
        }

        for (mutableEntry in table) {
            println("javaClass = ${mutableEntry}")
        }

        table.values.forEach { it.sort() }

        return query.map { q ->
            val tokens = q.replace(" and ", "").split(" ")  // ---- 150
            val score = tokens.last().toInt() // 150
            val realQuery = tokens.dropLast(1).joinToString("") //----
            table[realQuery]?.let { it.size - search(it, score) } ?: 0
        }.toIntArray()
    }

    fun search(arrNum: ArrayList<Int>, score: Int): Int { //score를 만족하는 숫자의 범위를 검색
        var low = 0
        var high = arrNum.size - 1
        while (low <= high) {
            val mid = (low + high) / 2
            if (arrNum[mid] < score) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return low
    }

    fun bruteForce(table: LinkedHashMap<String, ArrayList<Int>>, info: List<String>, score: Int, makeData: String, count: Int) {
        if (count == 4) {
            table.getOrPut(makeData) { ArrayList() }.add(score)
            return
        }
        bruteForce(table, info, score, makeData + info[count], count + 1) // "" -> "java" -> "javabackend" ....
        bruteForce(table, info, score, makeData + "-", count + 1)  //"javabackendjunior-" -> "javabackendjunior-pizza" -> ....
    }
}
