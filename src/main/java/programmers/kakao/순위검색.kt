package programmers.kakao

import java.util.*
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

class Solution2 {
    fun search(arrNum: ArrayList<Int>, score: Int): Int {
        var low = 0
        var high = arrNum.size - 1
        while (low <= high) {
            var mid = (low + high) / 2
            if (arrNum[mid] < score) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return low
    }

    fun dfs(infoMap: MutableMap<String, ArrayList<Int>>, info: List<String>, score: Int, sentence: String, cnt: Int) {
        if (cnt == 4) {
            infoMap.getOrPut(sentence) { ArrayList() }.add(score)
            return
        }
        dfs(infoMap, info, score, sentence + info[cnt], cnt + 1)
        dfs(infoMap, info, score, sentence + "-", cnt + 1)
    }

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val infoMap = mutableMapOf<String, ArrayList<Int>>()

        info.forEach { sen ->
            val tokens = sen.split(" ")
            dfs(infoMap, tokens, tokens.last().toInt(), "", 0)
        }

        infoMap.values.forEach { it.sort() }

        return query.map { q ->
            val tokens = q.replace(" and ", "").split(" ")
            val score = tokens.last().toInt()
            val sentence = tokens.dropLast(1).joinToString("")
            infoMap[sentence]?.let { it.size - search(it, score) } ?: 0
        }.toIntArray()
    }
}
