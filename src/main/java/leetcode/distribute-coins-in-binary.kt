package leetcode

import kotlin.math.abs

fun main() {

}

class Sol10 {

    private var count = 0
    fun distributeCoins(root: TreeNode?): Int {
        count = 0
        fun dfs(current: TreeNode?): Int {
            if (current == null) {
                return 0
            }

            val leftCoins = dfs(current.left)
            val rightCoins = dfs(current.right)

            count += abs(leftCoins) + abs(rightCoins)

            return (current.`val` - 1) + leftCoins + rightCoins
        }
        dfs(root)
        return count
    }


}