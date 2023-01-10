package editor.cn.DoubleWeekly95;

import java.io.FilterOutputStream;
import java.util.Arrays;

public class Q4 {
    public static void main(String[] args) {
        Solution solution = new Q4().new Solution();
        System.out.println(solution.maxPower(new int[]{1, 2, 4, 5, 0}, 1, 2));
    }
    class Solution{
        public long maxPower(int[] stations, int r, int k) {
            int right = stations.length;
            long min = Long.MAX_VALUE;
            if (stations.length == 0 || r == 0) return Arrays.stream(stations).min().getAsInt();

            long[] pre = new long[stations.length];
            pre[0] = stations[0];
            for (int i = 1; i < stations.length; i++) {
                pre[i] = pre[i - 1] + stations[i];
            }
            long[][] city = new long[stations.length][2];
            for (int i = 0; i < stations.length; i++) {
                city[i][0] = i;
//                city[i][1] = stations[i] + ;
            }
            Arrays.sort(city, (a, b) -> Math.toIntExact(a[1] - b[1]));
            return 1;
        }
    }
}
