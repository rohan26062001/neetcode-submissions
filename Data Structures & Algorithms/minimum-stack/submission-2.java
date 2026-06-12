class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> min;

    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        if(min.size() == 0) {
            min.push(val);
        } else {
            min.push(Math.min(val, min.peek()));
        }
        st.push(val);
    }
    
    public void pop() {
        st.pop();
        min.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
