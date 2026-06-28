package dsa_problems_concepts.impt_patterns;

class BinaryTree{
    TreeNode root;

    BinaryTree(TreeNode root){
        this.root = root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
    this.val =val;
    }
}

public class TreeTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        



    }
}
