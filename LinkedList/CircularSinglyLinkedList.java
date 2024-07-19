package LinkedList;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    public static class ListNode {

        private int data;
        private ListNode next = null;

        public ListNode(int data) {
            this.data = data;
        }

    }

    public CircularSinglyLinkedList() {
        last = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void createCircularLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(15);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }

    public void display() {
        if (last == null)
            return;

        ListNode first = last.next;

        while (first != last) {
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.print(first.data + " "); // Prints last node
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (last == null)
            last = newNode;
        else
            newNode.next = last.next;

        last.next = newNode;
        length++;
    }

    public void insertLast(int data) {
        ListNode newNode = new ListNode(data);

        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public ListNode removeFirst() {
        ListNode first = last.next;
        if (last == null)
            return null;
        else
            last.next = first.next;
        first.next = null;
        length--;
        return first;
    }

    public static void main(String[] args) {

        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.insertLast(1);
        csll.insertLast(2);
        csll.insertLast(3);
        csll.insertLast(4);
        csll.insertLast(5);
        csll.display();
    }

}
