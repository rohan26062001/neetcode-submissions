class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] ans = new int[n];

        Stack<Pair> st = new Stack<>();
        st.push(Pair.of(temps[0], 0));

        int i = 1;
        while(i < n) {
            Pair p = Pair.of(temps[i], i);
            while(!st.isEmpty() && st.peek().val < p.val) {
                Pair peek = st.pop();
                ans[peek.index] = i - peek.index;
            }
            st.push(p);
            i++;
        }

        return ans;
    }

    static class Pair {
        int val, index;

        private Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        public static Pair of(int val, int index) {
            return new Pair(val, index);
        }
    }
}
