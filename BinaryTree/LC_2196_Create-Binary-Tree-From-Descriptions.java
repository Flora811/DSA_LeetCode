/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for(int d[]: descriptions){
            map.putIfAbsent(d[0], new TreeNode(d[0]));
            map.putIfAbsent(d[1], new TreeNode(d[1]));

            if(d[2]==1) map.get(d[0]).left = map.get(d[1]);
            else map.get(d[0]).right = map.get(d[1]);

            children.add(d[1]);
        }

        for(int d[]: descriptions){
            if(!children.contains(d[0])) return map.get(d[0]);
        }

        return null;
    }
}