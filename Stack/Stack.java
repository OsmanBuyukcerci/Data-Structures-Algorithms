package Stack;

import java.util.EmptyStackException;

public class Stack {
    private ListNode top;
    private int length;

    public static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public Stack() {
        top = null;
        length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void display() {
        ListNode current = top;

        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null");
    }

    public void push(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty())
            top = newNode;
        else {
            newNode.next = top;
            top = newNode;
        }
        length++;
    }

    public ListNode pop() {
        ListNode temp = top;
        if (isEmpty())
            throw new EmptyStackException();
        else
            top = top.next;

        temp.next = null;
        length--;
        return temp;
    }

    public int peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return top.data;
    }

    public int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack stack = new Stack();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }
        return result;
    }

    // boolean isValid(String s) {
    // Stack<Character> = new Stack()<>;

    // for (char c : s.toString()) {
    // if (c == '(' || c = '[' || c = '{') {
    // stack.push(c);
    // } else {
    // if (stack.isEmpty()) {
    // return false;
    // } else {
    // char top = stack.peek();
    // if ((c == '(' && top == ')') || (c == '[' && top == ']') || (c == '{' && top
    // == '}')) {
    // stack.pop();
    // } else {
    // return false;
    // }
    // }
    // }
    // }

    // return stack.isEmpty();
    // }

    public static void main(String[] args) {
        Stack stack = new Stack();

        int[] deneme = stack.nextGreaterElement(new int[] { 1, 2, 3, 4, 5 });

        for (int i = 0; i < deneme.length; i++) {
            System.out.println(deneme[i]);
        }

    }
}
