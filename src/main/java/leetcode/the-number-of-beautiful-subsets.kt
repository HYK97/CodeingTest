package leetcode

import java.util.*


    fun beautifulSubsets(nums: IntArray, k: Int): Int {
        val freqMap: HashMap<Int, Int> = HashMap()
        Arrays.sort(nums)
        return counting(nums, k, freqMap, 0) - 1
    }

    private fun counting(nums: IntArray, difference: Int, map: HashMap<Int, Int>, i: Int): Int {
        if (i == nums.size) {
            return 1
        }

        var count = counting(nums, difference, map, i + 1)

        if (!map.containsKey(nums[i] - difference)) {
            map[nums[i]] = map.getOrDefault(nums[i], 0) + 1
            count += counting(nums, difference, map, i + 1)
            map[nums[i]] = map[nums[i]]!! - 1
            if (map[nums[i]] == 0) {
                map.remove(nums[i])
            }
        }

        return count
    }
