class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        
        //leaf 노드 일때
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        
        //왼쪽 순회
        boolean hasLeftPath = hasPathSum(root.left, targetSum - root.val);
        //오른쪽 순회
        boolean hasRightPath = hasPathSum(root.right, targetSum - root.val);
        
        return hasLeftPath || hasRightPath; //왼쪽 오른쪽 왼쪽 하나라도 존재하면 true
    }
}