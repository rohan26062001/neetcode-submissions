class MinStack {

    Stack<Integer> st, min;

    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty())
            min.push(val);
        else 
            min.push(Math.min(min.peek(), val));
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
