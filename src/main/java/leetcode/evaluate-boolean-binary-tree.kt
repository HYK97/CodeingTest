fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Sol9 {
    fun evaluateTree(root: TreeNode?): Boolean {
        return dfs(root)
    }
    fun dfs(root: TreeNode?): Boolean {
        if (root?.left == null || root?.right == null) {
            return root?.`val`!! != 0
        }
        if (root.`val` == 2) {
            return dfs(root.left) || dfs(root.right)
        }
        return dfs(root.left) && dfs(root.right)
    }
}