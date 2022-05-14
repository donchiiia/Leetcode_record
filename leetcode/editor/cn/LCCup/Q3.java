package LCCup;


import LCCup.TreeNode;
import java.util.HashMap;
import java.util.HashSet;

public class Q3 {
	public static void main(String[] args) {

	}
	class Solution {
		public int getNumber(TreeNode root, int[][] ops) {
			int[] res = new int[10^5];
			for (int i = 0; i < ops.length; i++) {
				for (int j = ops[i][1]; j <= ops[i][2]; j++) {
					if (findNode(root, j)) {
						if (ops[i][0] == 1) res[j] = 1;
						res[j] = 0;
					}
				}
			}
			int count = 0;
			for(int k : res){
				if (k == 1) count++;
			}
			return count;
/*			HashMap<Integer, Boolean> integerIntegerHashMap = new HashMap<>();
			for (int i = 0; i < ops.length; i++) {
				for (int j = ops[i][1]; j <= ops[i][2]; j++) {
					integerIntegerHashMap.put(j, ops[i][0] == 1);
				}
			}
			int count = 0;
			for (Integer integer : integerIntegerHashMap.keySet()) {
				if (findNode(root, integer) && integerIntegerHashMap.get(integer)) count++;
			}
			return count;*/
		}

		private boolean findNode(TreeNode root, int value) {
			if (root == null) return false;
			if (root.val == value) return true;
			else if (root.val > value) return findNode(root.left, value);
			else return findNode(root.right, value);
		}
	}
}
