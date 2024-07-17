import baekjoon.backtraking.s

class Sol33 {
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