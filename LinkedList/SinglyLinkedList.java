package LinkedList;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void printList() {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null \n");
    }

    public int findLength() {
        int counter = 0;
        ListNode current = head;
        while (current != null) {
            counter++;
            current = current.next;
        }
        return counter;
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int data) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            head = newNode;
            return;
        }

        ListNode current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insert(int data, int position) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            head = newNode;
            return;
        } else if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        ListNode current = head;
        int counter = 1;

        while (counter != position - 1) {
            current = current.next;
            counter++;
        }

        ListNode temp = current.next;
        current.next = newNode;
        newNode.next = temp;
    }

    public ListNode deleteFirst() {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        head = head.next;
        current = head;

        return current;
    }

    public ListNode deleteLast() {
        if (head == null || head.next == null)
            return head;

        ListNode current = head;
        ListNode previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        previous.next = null;

        return current;
    }

    public void delete(int position) {

        if (position == 1) {
            head = head.next;
        } else {
            ListNode temp = null;
            ListNode current = head;

            int counter = 1;

            while (counter != position) {
                temp = current;
                current = current.next;
                counter++;
            }

            temp.next = current.next;
        }
    }

    public boolean search(int searchKey) {
        ListNode current = head;
        while (current.next != null) {
            if (current.data == searchKey)
                return true;
            current = current.next;
        }

        return false;
    }

    public int searchPosition(int searchKey) {
        ListNode current = head;
        int position = 1;
        while (current.data != searchKey) {
            position++;
            if (current.next == null && current.data != searchKey)
                return 0;
            current = current.next;
        }
        return position;
    }

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode next = null;
        ListNode current = head;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    // public ListNode findFromEnd(int positionEnd) {
    // ListNode current = head;

    // int counter = 0;

    // while (current != null) {
    // counter++;
    // current = current.next;
    // }

    // int position = counter - positionEnd + 1;
    // counter = 1;

    // current = head;

    // while (counter != position) {
    // current = current.next;
    // counter++;
    // }

    // return current;
    // }

    public ListNode findFromEnd(int positionEnd) {
        ListNode mainPtr = head;
        ListNode refPtr = head;

        int counter = 0;

        while (counter < positionEnd) {
            refPtr = refPtr.next;
            counter++;
        }

        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;

    }

    // public void removeDuplicatesFromSortedList() {
    // if (head == null || head.next == null)
    // return;

    // ListNode previous = null;
    // ListNode current = head;

    // while (current != null && current.next != null) {
    // if (current.data == current.next.data) {
    // previous = current;
    // current = current.next;
    // previous.next = current.next;
    // } else
    // current = current.next;
    // }
    // }

    public void removeDuplicatesFromSortedList() {
        if (head == null || head.next == null)
            return;

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data)
                current.next = current.next.next;
            else
                current = current.next;
        }
    }

    public void insertSortedList(int data) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            head = newNode;
            return;
        }

        if (head.data == newNode.data) {
            newNode.next = head;
            head = newNode;
            return;
        }

        ListNode previous = null;
        ListNode current = head;

        while (current != null && current.data < newNode.data) {
            previous = current;
            current = current.next;
        }

        newNode.next = current;
        previous.next = newNode;
    }

    public void removeGivenKey(int key) {
        if (head == null) {
            return;
        }

        ListNode previous = null;
        ListNode current = head;

        while (current != null && current.data != key) {
            previous = current;
            current = current.next;
        }

        if (current == null)
            return;

        previous.next = current.next;
    }

    public boolean detectLoop() {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (slowPtr == fastPtr)
                return true;
        }
        return false;
    }

    public ListNode getStartingNode(ListNode slowPtr) {
        ListNode temp = head;

        while (temp != slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    public ListNode findStartofLoop() {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr)
                return getStartingNode(slowPtr);
        }
        return null;
    }

    public void removeLoop(ListNode slowPtr) {
        ListNode temp = head;

        while (slowPtr.next != temp.next) {
            slowPtr = slowPtr.next;
            temp = temp.next;
        }
        slowPtr.next = null;
    }

    public void listWithoutLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                removeLoop(slowPtr);
                return;
            }
        }
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if (a == null)
            tail.next = b;
        else
            tail.next = a;

        return dummy.next;
    }

    public ListNode add(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int carry = 0;

        while (a != null || b != null) {
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            if (a != null)
                a = a.next;
            if (b != null)
                b = b.next;
        }

        if (carry > 0)
            tail.next = new ListNode(carry);

        return dummy.next;
    }

    public static void main(String[] args) {

        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(5);
        ListNode second = new ListNode(6);
        ListNode third = new ListNode(7);

        sll.head.next = second; // 1 --> 1
        second.next = third; // 1 --> 1 --> 2

        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.head = new ListNode(3);
        ListNode second2 = new ListNode(5);
        ListNode third2 = new ListNode(0);

        sll2.head.next = second2;
        second2.next = third2;

        int counter = sll.findLength();
        System.out.println(counter);
    }
}