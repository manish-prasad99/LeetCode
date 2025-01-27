class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') { // opening
                st.push(c);
            } else {
                if (st.empty()) { // closing -- 1. Stack should not be Empty
                    return false;
                }
                char top = st.peek();
                st.pop();

                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) { // matching condition
                    return false;
                }
            }
        }
        return st.empty(); // Stack should be Empty
    }
}
