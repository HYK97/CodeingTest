class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, currentPath, targetSum);
        return answer;
    }

    private void dfs(TreeNode node, List<Integer> path, int targetSum) {
    
        if (node == null) {
            return;
        }

        path.add(node.val);
        
        if (node.left == null && node.right == null && targetSum == node.val) {
            answer.add(new ArrayList<>(path));
        }

        dfs(node.left, path, targetSum - node.val);
        dfs(node.right, path, targetSum - node.val);

        path.remove(path.size() - 1);
    }
}