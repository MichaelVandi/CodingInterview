public class MyClass {
    public static void main(String args[]) {
    }

}
public class MyQueue {
    Stack<Integer> stackNewest = new Stack<>();
    Stack<Integer> stackOldest = new Stack<>();
    
    public int peek(){
        // Return from the oldest stack
        shiftStacks();
        int newestNum = stackOldest.peek();
        return newestNum;
    }
    public void push(int num) {
        // Push to the newest
        stackNewest.push(num);
    }
    public int pop() {
        // Remove from the oldest stack but make sure oldest
        // has something in it
        shiftStacks();
        int value = stackOldest.pop();
        return value;
    }
    public void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }
    
}