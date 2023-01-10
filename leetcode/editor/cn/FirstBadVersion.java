package editor.cn;

/**
You are a product manager and currently leading a team to develop a new product.
 Unfortunately, the latest version of your product fails the quality check. 
Since each version is developed based on the previous version, all the versions 
after a bad version are also bad. 

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first 
bad one, which causes all the following ones to be bad. 

 You are given an API bool isBadVersion(version) which returns whether version 
is bad. Implement a function to find the first bad version. You should minimize 
the number of calls to the API. 

 
 Example 1: 

 
Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
 

 Example 2: 

 
Input: n = 1, bad = 1
Output: 1
 

 
 Constraints: 

 
 1 <= bad <= n <= 2³¹ - 1 
 
 Related Topics 二分查找 交互 👍 618 👎 0

*/
  
  public class FirstBadVersion{
      static boolean[] aim = {false, false, false,false, false, true};
      public static void main(String[] args) {
           Solution solution = new FirstBadVersion().new Solution();
          System.out.println(solution.firstBadVersion(aim.length)+"#"+ solution.count);
      }

      class VersionControl {
          int count = 0;
          boolean isBadVersion(int version) {
              count++;
              return aim[version - 1];
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
/*        int from = 1, to = n;
        if (n == 1) return 1;
        while (from <= to) {
            int mid = from + ((to - from) >> 1);
            if (isBadVersion(mid) == true)
                to = mid - 1;
            else from = mid + 1;
        }
        return to + 1;*/

        int tag =  0, from = 1, to = n;
        if (n == 1) return 1;
        while(from<=to){
            int mid = from+(to-from)/2;
            if(isBadVersion(mid) == true){
                to = mid - 1;
                tag = mid;
            }else{
                from = mid + 1;
            }
        }
        return tag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }