class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(tokens[i].equals("+")){
                int second = st.pop();
                int first = st.pop();
                st.push(first+second);
            }
            else if(tokens[i].equals("-")){
                int second = st.pop();
                int first = st.pop();
                st.push(first-second);
            }
            else if(tokens[i].equals("*")) {
                int second = st.pop();
                int first = st.pop();
                st.push(first*second);
            }
            else if(tokens[i].equals("/")) {
                int second = st.pop();
                int first = st.pop();
                st.push(first/second);
            }
            else
                st.push(Integer.parseInt(tokens[i]));
        }

        return st.pop();
    }
}
