- 由此可得出更通用的NSum问题的解法

```java
import java.util.Arrays;
import java.util.List;

public class NSum {
    public List<List<Integer>> NSumPre(int[] nums, int n, int target) {
        Arrays.sort(nums);
        return NSumTarget(nums, n, 0, target);
    }

    //通过n和start来辅助递归时的层数和起始位置
    public List<List<Integer>> NSumTarget(int[] nums, int n, int start, int target) {
        int length = nums.length;
        List<List<Integer>> res = new List<>();

        if (n < 2 || length < n) return res;
        //n==2时不用递归，属于极限情况的处理
        if (n == 2) {
            int lo = start, hi = length - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int leftValue = nums[lo], rightValue = nums[hi];
                if (sum < target) {
                    while (lo < hi && nums[lo] == leftValue) lo++;
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == rightValue) hi--;
                } else {
                    List<Integer> list = new List<>();
                    list.add(nums[lo]);
                    list.add(nums[hi]);
                    res.add(list);
                    while (lo < hi && nums[lo] == leftValue) lo++;
                    while (lo < hi && nums[hi] == rightValue) hi--;
                }
            }
        } else {
            for (int i = start; i < length; i++) {
                List<List<Integer>> subLists = NSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> sublist : subLists) {
                    sublist.add(nums[i]);
                    res.add(sublist);
                }
                while (i < length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
```