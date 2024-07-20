package Queue;

import java.util.NoSuchElementException;

public class Queue {

    private ListNode front;
    private ListNode rear;
    private int length;

    public static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void display() {
        ListNode current = front;
        System.out.println("\n");
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null \n");
    }

    public void enqueue(int data) {
        ListNode newNode = new ListNode(data);

        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("There is no list node for dequeue");
        }
        int temp = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        length--;
        return temp;
    }
}
