package leetcode

fun main() {
    val findRelativeRanks = Relative_Rank().findRelativeRanks(intArrayOf(10, 3, 8, 9, 4))
    println(findRelativeRanks.contentToString())
}

class Relative_Rank {
    fun findRelativeRanks(score: IntArray): Array<String> {

        val reversed = score.sorted().reversed()

        val map = HashMap<Int, Int>()

        reversed.forEachIndexed { index, i ->
            map[i] = index + 1
        }

        val answer = Array(score.size) { "" }
        for ((index, i) in score.withIndex()) {
            val rank = map[i].toString()
            if (rank == "1") {
                answer[index] = "Gold Medal"
                continue
            }
            if (rank == "2") {
                answer[index] = "Silver Medal"
                continue
            }
            if (rank == "3") {
                answer[index] = "Bronze Medal"
                continue
            }
            answer[index] = rank
        }

        return answer

    }
}