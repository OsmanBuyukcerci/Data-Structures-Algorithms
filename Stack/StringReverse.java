package Stack;

import java.util.Stack;

public class StringReverse {

    public static String reverse(String str) {
        Stack<Character> stack = new Stack<>();
        char[] charArr = str.toCharArray();

        for (char key : charArr) {
            stack.push(key);
        }

        for (int i = 0; i < str.length(); i++) {
            charArr[i] = stack.pop();
        }

        return new String(charArr);
    }

    public static void main(String[] args) {
        String result = reverse("osman");
        System.out.println(result);
    }

}
