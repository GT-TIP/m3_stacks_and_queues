import java.util.Stack;

/**
 * @author: Jenna Kwon jkwon47@gatech.edu. Email if you have any questions!
 *
 * This code is for the workshop at Georgia Tech Technical Interview Prep Club.
 * Slides pertaining to this module's code is at: http://bitly.com/gttip_fall2016_m3
 *
 * Given a string containing just the characters ’(’, ’)’, ’[’ and ’]’,
 * determine if the input string is valid.
 * The brackets must close in the correct order,
 * "()" and "()[]" are all valid but "(]" and "([)]" are not.
 *
 * Input: string mixing of brackets
 * Output: bool isValid
 *
 * Example: "()()[]" - > true
 *          "[)(}" -> false
 *
 */

public class Advanced {

    public static boolean isValidBraces(String s) {
        if (s.length() == 0) { return true; }

        Stack<Character> openingBraces = new Stack<>();

        for (Character c : s.toCharArray()) {
            if ("([{".contains(c.toString())) {
                openingBraces.push(c);
            } else {
                if ((c == ']' && openingBraces.peek() != '[')
                    || (c == ')' && openingBraces.peek() != '(')
                    || (c == '}' && openingBraces.peek() != '{')){
                    return false;
                }
                openingBraces.pop();
            }
        }

        // must check that there are no leftover opening braces
        return openingBraces.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidBraces("((]]"));
        System.out.println(isValidBraces("({})"));
        System.out.println(isValidBraces("([][])"));
    }
}
