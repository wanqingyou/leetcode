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

   public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null) {
				sb.append("n ");
				continue;
			}
			sb.append(cur.val + " ");
			queue.add(cur.left);
			queue.add(cur.right);
		}

		return sb.toString();
	}

	public TreeNode deserialize(String data) {
		if (data == "") return null;

		String values[] = data.split(" ");
		TreeNode root = new TreeNode(Integer.parseInt(values[0]));
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		for (int i = 1; i < values.length; i++) {
			if (!queue.isEmpty()) {
				TreeNode parent = queue.poll();
				if (!values[i].equals("n")) {
					TreeNode left = new TreeNode(Integer.parseInt(values[i]));
					parent.left = left;
					queue.add(left);
				}
				if (!values[++i].equals("n")) {
					TreeNode right = new TreeNode(Integer.parseInt(values[i]));
					parent.right = right;
					queue.add(right);
				}
			}
		}

		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));