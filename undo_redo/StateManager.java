class StateManager {
    private class Node {
        String state;
        Node prev, next;

        Node(String state) {
            this.state = state;
        }
    }

    private Node head = null;
    private Node current = null;

    public void addState(String state) {
        Node newNode = new Node(state);

        if (head == null) {
            head = newNode;
        } else {
            current.next = null;
            newNode.prev = current;
            current.next = newNode;
        }

        current = newNode;
        System.out.println("Added state: " + state);
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: Now at state " + current.state);
        } else {
            System.out.println("Cannot undo");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: Now at state " + current.state);
        } else {
            System.out.println("Cannot redo");
        }
    }

    public void printCurrent() {
        if (current != null) {
            System.out.println("Current state: " + current.state);
        } else {
            System.out.println("No current state.");
        }
    }
}