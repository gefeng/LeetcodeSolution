package solution;

import annotations.Problem;
import enums.QDifficulty;
import enums.QTag;

import java.util.ArrayDeque;
import java.util.Deque;

@Problem(
        title = "Valid Parenthesis String",
        difficulty = QDifficulty.MEDIUM,
        tag = QTag.STRING,
        url = "https://leetcode.com/problems/valid-parenthesis-string/"
)
public class Q678 {
    /**
     * Time:  O(N)
     * Space: O(N)
     * */
    public boolean checkValidString(String s) {
        int n = s.length();
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack1.push(i);
            } else if(c == ')') {
                if(!stack1.isEmpty()) stack1.pop();
                else if(!stack2.isEmpty()) stack2.pop();
                else return false;
            } else {
                stack2.push(i);
            }
        }

        while(!stack1.isEmpty()) {
            if(!stack2.isEmpty() && stack2.peek() > stack1.peek()) {
                stack1.pop();
                stack2.pop();
            } else {
                return false;
            }
        }

        return true;
    }
}
