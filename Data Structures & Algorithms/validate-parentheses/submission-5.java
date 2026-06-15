class Solution {
    public boolean isValid(String s) {
        Stack<String> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            String value = String.valueOf(s.charAt(i));

            if(value.equals("(") || value.equals("{") || value.equals("["))
                st.push(value);
            else {
                if(value.equals(")")){
                    if(!st.isEmpty() && st.peek().equals("("))
                        st.pop();
                    else return false;
                } else if(value.equals("}")){
                    if(!st.isEmpty() && st.peek().equals("{"))
                        st.pop();
                    else return false;
                } else if(value.equals("]")){
                    if(!st.isEmpty() && st.peek().equals("["))
                        st.pop();
                    else return false;
                }
            }
        }

        return st.size() == 0;
    }
}
