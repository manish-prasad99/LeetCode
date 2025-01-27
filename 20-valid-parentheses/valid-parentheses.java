// class Solution {
//     public boolean isValid(String s) {
        
//         Stack <Character>st=new Stack<>();

//         for(int i=0;i<s.length();i++){
//             char c= s.charAt(i);

//             if(c=='('||c =='['||c=='{')                                   //opening
//             {  
//                 st.push(c);
                
//             }
//             else{
//                 return false;
//             }
//             if(st.empty()){     //closing -- 1. Stack not Empty
//                 return false;
//             }
//             else{               //transfer and remove
//                 c = st.peek();
//                 st.pop();
//             }
//             if((c==')'&& c =='(')||(c=='}'&& c=='{')||(c==']'&& c =='[')){      //matching condition
                
//             }
//             else {
//                 return false;
//             }
//         }
//         if(st.empty()){         //Stack should be Empty
//             return true;
//         }
//         else{
//             return false;
//         }
//     }
// }


import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        String test1 = "()";
        String test2 = "()[]{}";
        String test3 = "(]";
        String test4 = "([)]";
        String test5 = "{[]}";

        System.out.println("Test 1: " + solution.isValid(test1)); // Expected: true
        System.out.println("Test 2: " + solution.isValid(test2)); // Expected: true
        System.out.println("Test 3: " + solution.isValid(test3)); // Expected: false
        System.out.println("Test 4: " + solution.isValid(test4)); // Expected: false
        System.out.println("Test 5: " + solution.isValid(test5)); // Expected: true
    }
}

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
