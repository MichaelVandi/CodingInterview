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