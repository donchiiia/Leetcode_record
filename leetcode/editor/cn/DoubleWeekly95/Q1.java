package editor.cn.DoubleWeekly95;

public class Q1 {
    public static void main(String[] args) {
        Solution solution = new Q1().new Solution();
        System.out.println(solution.categorizeBox(2909,
                3968,
                3272,
                727));
    }
    class Solution{
        public String categorizeBox(int length, int width, int height, int mass) {
            String res = "";
            long lmass = 0;
            lmass = (long) length * (long) width * (long) height;
            if (lmass >= (1e9) || length >= (1e4) || width >= (1e4) || height >= (1e4)) res = "Bulky";
            if (mass >= 100) {
                if (res.equals("Bulky")) return "Both";
                return "Heavy";
            } else {
                if (res.equals("Bulky")) return res;
                return "Neither";
            }
        }
    }
}
