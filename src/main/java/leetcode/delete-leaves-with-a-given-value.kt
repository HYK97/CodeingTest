package leetcode

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

fun main() {
    val root = TreeNode(1)
    val one = TreeNode(1)
    val two = TreeNode(1)
    val three = TreeNode(2)
    root.left = one
    root.right = two

    val removeLeafNodes = Sol9().removeLeafNodes(root, 1)

}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Sol9 {
    var realroot:TreeNode?=null
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        //realroot=root
        dfs(root, target, null, null)
        if (root!!.left == null && root!!.right == null && root.`val` == target) {
            return null
        }
        return root
    }

    fun dfs(root: TreeNode?, target: Int, prev: TreeNode?, isLeft: Boolean?) {
        var left = root!!.left
        var right = root!!.right

        if (left != null) {
            dfs(left, target, root, true)
            left = root!!.left
        }
        if (right != null) {
            dfs(right, target, root, false)
            right = root!!.right
        }
        if (prev==null) {
            return
        }
        if (left == null && right == null) {
            if (isLeft!! && root.`val` == target) {
                prev!!.left = null
            }
            if (!isLeft!! && root.`val` == target) {
                prev!!.right = null
            }
        }
        return
    }
}