/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data=="") return null;
        String[] tree= data.split(" ");
        TreeNode root= new TreeNode(Integer.parseInt(tree[0]));
        Queue<TreeNode> q= new LinkedList();
        q.add(root);
        for (int i= 1; i<tree.length; i++) {
            TreeNode parent= q.poll();
            if (!tree[i].equals("n")){
                TreeNode left= new TreeNode(Integer.parseInt(tree[i]));
                parent.left= left;
                q.add(left);
            }
            i= i+1;
            if (!tree[i].equals("n")){
                TreeNode right= new TreeNode(Integer.parseInt(tree[i]));
                parent.right= right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));