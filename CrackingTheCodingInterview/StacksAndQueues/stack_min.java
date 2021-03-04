public import java.util.*;
class MinStack {

    /** initialize your data structure here. */
    List<Integer> stack = new ArrayList<>();
    List<Integer> minStack = new ArrayList<>();
    public MinStack() {

    }
    
    public void push(int x) {
        int min = x;
        if (stack.size() > 0) {
            // Means there are items here and we need to calculate the curr min
            int lastMin = minStack.get(minStack.size() - 1);
            min = Math.min(lastMin, min);
        }
        minStack.add(min);
        stack.add(x);
        System.out.print(x + " -> ");
        System.out.println("Min : " + min);
    }
    
    public void pop() {
        minStack.remove(minStack.size() - 1);
        stack.remove(stack.size() - 1);
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return minStack.get(minStack.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */class stack_min {
    
}
