package programmers.impl

class 로또의최고순위와최저순위 {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var min = 0
        var zeroCount = 0
        val rank = mapOf(Pair(6, 1), Pair(5, 2), Pair(4, 3), Pair(3, 4), Pair(2, 5), Pair(1, 6), Pair(0, 6))
        for (i in lottos) {
            if (win_nums.contains(i)) {
                min++
            }
            if (i == 0) {
                zeroCount++
            }
        }
        val max = min + zeroCount
        return intArrayOf(rank.get(max)!!, rank.get(min)!!)
    }
}