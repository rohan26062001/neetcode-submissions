class MinStack {

    private final Stack<Integer> main;
    private final Stack<Integer> min;

    public MinStack() {
        main = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        main.push(val);

        // push in min
        if(min.isEmpty())
            min.push(val);
        else 
            min.push(Math.min(val, min.peek()));
    }
    
    public void pop() {
        main.pop();
        min.pop();
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
