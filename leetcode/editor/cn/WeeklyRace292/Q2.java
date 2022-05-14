package WeeklyRace292;

import com.sun.source.tree.Tree;

public class Q2 {
	public static void main(String[] args) {
		Solution solution = new Q2().new Solution();
	}
	  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

	class Solution{
		int res = 0;
		public int averageOfSubtree(TreeNode root) {
			helper(root);
			return res;
		}

		public int[] helper(TreeNode root) {
			if (root == null) return new int[]{0, 0};

			int[] leftRes = helper(root.left), rightRes = helper(root.right);
			if ((leftRes[1] + rightRes[1] + root.val) / (leftRes[0] + rightRes[0] + 1) == root.val) res++;
			return
				new int[]{leftRes[0] + rightRes[0] + 1, leftRes[1] + rightRes[1] + root.val};
		}
	}
}
