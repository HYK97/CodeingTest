package leetcode

fun main() {
    val maximumEnergy = Sol5().maximumEnergy(intArrayOf(5, 2, -10, -5, 1), 3)
    println("maximumEnergy = ${maximumEnergy}")

    val maximumEnergy2 = Sol5().maximumEnergy(intArrayOf(-2,-3,-1), 2)
    println("maximumEnergy = ${maximumEnergy2}")
}

class Sol5 {
    fun maximumEnergy(energy: IntArray, k: Int): Int {
        var max = Int.MIN_VALUE
        for (energy1 in energy.withIndex()) {
            var sum =0
            for (energy2 in energy1.index until  energy.size step k) {
                sum+=energy[energy2]
            }
            max = maxOf(max,sum)
        }
        return max
    }

    fun maximumEnergy2(energy: IntArray, k: Int): Int {
        val n = energy.size
        val dp = IntArray(n) { 0 }

        for (i in n - 1 downTo 0) {
            dp[i] = energy[i]
            if (i + k < n) {
                dp[i] += dp[i + k]
            }
        }

        return dp.maxOrNull() ?: 0
    }
}