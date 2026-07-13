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

    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int inStart, int inEnd) {

        // Base case
        if (inStart > inEnd) {
            return null;
        }

        // First element in preorder is the root
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;

        // Find root in inorder
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        // Build left subtree
        root.left = build(preorder, inorder, inStart, index - 1);

        // Build right subtree
        root.right = build(preorder, inorder, index + 1, inEnd);

        return root;
    }
}