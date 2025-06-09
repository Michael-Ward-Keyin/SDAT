class Node {
    public int value;
    public Node next;
}

public class SingleLinkedListTest {
    public Node head;
    public Node tail;
    public int size;

    public Node createSingleLinkedlist(int nodeValue) {
        Node node = new Node();
        node.value = nodeValue;
        node.next = null;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        if (head == null) {
            createSingleLinkedlist(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print("->");
                }
                tempNode = tempNode.next;
            }
            System.out.println();
        }
    }

    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node at location: " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    public void delete(int position) {
        if (head == null) {
            System.out.println("List does not exist.");
            return;
        }

        if (position < 0 || position >= size) {
            System.out.println("Invalid position: " + position);
            return;
        }

        if (position == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            System.out.println("Node deleted at position 0");
            return;
        }

        Node tempNode = head;
        for (int i = 0; i < position - 1; i++) {
            tempNode = tempNode.next;
        }

        tempNode.next = tempNode.next.next;

        if (position == size - 1) {
            tail = tempNode;
        }

        size--;
        System.out.println("Node deleted at position " + position);
    }

    public static void main(String[] args) {
        SingleLinkedListTest list = new SingleLinkedListTest();

        list.createSingleLinkedlist(10);
        list.insertLinkedList(20, 1);
        list.insertLinkedList(30, 2);
        list.insertLinkedList(40, 3);
        list.insertLinkedList(50, 4);

        System.out.println("Original List:");
        list.traverseLinkedList();

        list.delete(0);
        System.out.println("After deleting at position 0:");
        list.traverseLinkedList();

        list.delete(1);
        System.out.println("After deleting at position 1:");
        list.traverseLinkedList();

        list.delete(2);
        System.out.println("After deleting at last position:");
        list.traverseLinkedList();

        list.delete(10);
    }
}
