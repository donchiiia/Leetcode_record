package editor.cn.DoubleWeekly95;

public class Q3 {
    public static void main(String[] args) {
        Solution solution = new Q3().new Solution();
        System.out.println(solution.xorBeauty(new int[]{15,45,20,2,34,35,5,44,32,30}));
    }
    class Solution{
        public int xorBeauty(int[] nums) {
 /*           int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    for (int k = 0; k < nums.length; k++) {
                        sum ^= (nums[i] | nums[j]) & nums[k];
                    }
                }
            }
            return sum;*/
            int sum = 0;
            for (int num : nums) {
                sum ^= num;
            }
            return sum;
        }
    }
}
