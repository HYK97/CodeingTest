/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    var result = mutableListOf<String>()
    fun binaryTreePaths(root: TreeNode?): List<String> {
        dfs(root, root?.`val`.toString() + "->")
        return result
    }

    fun dfs(next: TreeNode?, string: String) {
        if (next == null) {
            return
        }
        if (next?.right == null && next?.left == null) {
            val dropLast = string.dropLast(2)
            result.add(dropLast)
            return
        }
        dfs(next.left, string + next.left?.`val` + "->")
        dfs(next.right, string + next.right?.`val` + "->")
    }
}