/**
 * Prompt: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    An input string is valid if:
    1. Open brackets must be closed by the same type of brackets.
    2. Open brackets must be closed in the correct order.
 */

class Solution {
    public boolean isValid(String s) {
        
        Stack<String> stack = new Stack<>();
        String openingBraces = "({[";
        String closingBraces = "]})";
        Map<String, String> combinations = new HashMap<>();
        combinations.put(")", "(");
        combinations.put("}", "{");
        combinations.put("]", "[");
        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            
            String currentChar = String.valueOf(s.charAt(i));
            if(openingBraces.contains(currentChar)){
                // Then we know its an opening brace
                stack.push(currentChar);
            }
            else if (closingBraces.contains(currentChar)){
                // Then we know its a closing brace
                if (stack.isEmpty()){
                    return false;
                }
                if (stack.peek().equals(combinations.get(currentChar))){
                    // Do something
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}