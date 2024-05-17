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
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
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