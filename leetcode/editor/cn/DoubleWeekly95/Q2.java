package editor.cn.DoubleWeekly95;

public class Q2 {
    public static void main(String[] args) {
        Solution solution = new Q2().new Solution();
        Solution.DataStream dataStream = solution.new DataStream(2, 2);
        System.out.println(dataStream.consec(5));
        System.out.println(dataStream.consec(4));
        System.out.println(dataStream.consec(1));
        System.out.println(dataStream.consec(2));
        System.out.println(dataStream.consec(2));
        System.out.println(dataStream.consec(5));
        System.out.println(dataStream.consec(2));
        System.out.println(dataStream.consec(2));
        System.out.println(dataStream.consec(2));
        System.out.println(dataStream.consec(2));
        System.out.println(dataStream.consec(3));
    }

    class Solution {
        class DataStream {
            int[] line;
            int k;
            int v;
            int index = 0;
            int cnt = 0;

            public DataStream(int value, int k) {
                line = new int[k];
                this.k = k;
                v = value;
            }

            public boolean consec(int num) {
                if (line[index % k] == v) cnt--;
                line[index % k] = num;
                index++;
                index %= k;
                if (num == v) cnt++;
                if (cnt == k) return true;
                else return false;
            }
        }
    }
}
