class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] ans = new int[n];
        Stack<List<Integer>> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            int temp = temps[i];

            if(st.isEmpty()) {
                List<Integer> list = new ArrayList<>(2);
                list.add(temp);
                list.add(i);
                st.push(list);
            } else {
                List<Integer> lastElem;
                while(!st.isEmpty() && st.peek().get(0) < temp) {
                    lastElem = st.pop();
                    ans[lastElem.get(1)] = i - lastElem.get(1);
                }
                
                List<Integer> list = new ArrayList<>(2);
                list.add(temp);
                list.add(i);
                st.push(list);
            }
        }

        return ans;
    }
}
