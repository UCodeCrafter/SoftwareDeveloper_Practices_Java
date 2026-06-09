package dsa_problems_concepts.impt_patterns;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
        this.next = null;
    }
}
class ListNode {
    Node head;

    ListNode(int val) {
        this.head = new Node(val);
    }

    void addNode(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void printNodes() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }

}

    public class SlowAndFastPointers {
        public static void main(String[] args) {
            ListNode listNode = new ListNode(1);
            listNode.addNode(2);
            listNode.addNode(3);
            listNode.addNode(4);
            listNode.addNode(5);
            listNode.addNode(6);
            listNode.addNode(7);
            listNode.addNode(8);
            listNode.addNode(9);
            listNode.addNode(10);

            listNode.printNodes();

            System.out.println("Cycle exist or not in ListNode:" + cycleExistsOrNot(listNode.head));



    }

        private static boolean cycleExistsOrNot(Node head) {
            if (head == null || head.next == null) return false;

            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;         // Move 1 step
                fast = fast.next.next;    // Move 2 steps

                // Compare the objects, not their values!
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
