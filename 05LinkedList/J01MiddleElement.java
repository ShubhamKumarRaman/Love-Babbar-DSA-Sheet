
public class J01MiddleElement {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Approach 1:- slow fast pointer
    public static Node findMidList(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String args[]) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.println("Middle element is : " + findMidList(head).data);

        head.next.next.next.next.next = new Node(60);

        System.out.println("Middle element is : " + findMidList(head).data);
    }
}
