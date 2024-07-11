package LinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    public static class ListNode {

        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data) {
            this.data = data;
        }

    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void displayForward() {
        if (head == null)
            return;

        ListNode current = head;

        System.out.println("");

        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }

        System.out.print("null \n");
    }

    public void displayBackward() {
        if (tail == null)
            return;

        ListNode current = tail;

        System.out.println("");
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.previous;
        }
        System.out.println("null \n");
    }

    public void insertLast(int data) {
        ListNode newNode = new ListNode(data);

        if (isEmpty())
            head = newNode;
        else {
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
        length++;
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);

        if (isEmpty())
            tail = newNode;
        else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public ListNode deleteFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        else if (head == tail) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode deleteLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        else if (head == tail)
            tail = null;
        else
            tail.previous.next = null;
        ListNode temp = tail;
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // List
        dll.insertLast(1);
        dll.insertLast(10);
        dll.insertLast(33);
        dll.insertLast(5);

        // Functions
        dll.displayForward();
        dll.deleteLast();
        dll.deleteLast();
        dll.deleteLast();
        dll.displayForward(); // 1 --> null

    }

}
