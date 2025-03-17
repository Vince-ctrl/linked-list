public class LinkedList {
    private Node head; // Head of the linked list
    private Node tail; // Tail of the linked list for queue functionality
    private Node currentNode; // Tracks the current position in the list

    // Node class to represent each element in the linked list
    private static class Node {
        String value;
        Node next;

        // Constructor to initialize a node with a value
        Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
    }

    // Add a ball to the linked list (used for both stack and queue)
    public void addBall(String ball) {
        Node newNode = new Node(ball);
        if (head == null) {
            head = newNode;
            tail = newNode;
            currentNode = head;
        } else {
            tail.next = newNode; // Append to the end for queue
            tail = newNode;
        }
    }

    // Stack operation: Push a ball onto the stack
    public void push(String ball) {
        Node newNode = new Node(ball);
        if (head == null) {
            head = newNode;
            tail = newNode;
            currentNode = head;
        } else {
            newNode.next = head; // Add to the front for stack
            head = newNode;
        }
    }

    // Stack operation: Pop a ball from the stack
    public String pop() {
        if (head == null) {
            System.out.println("Stack is empty.");
            return null;
        }
        String value = head.value;
        head = head.next; // Remove the first node
        if (head == null) {
            tail = null; // If the list becomes empty
        }
        return value;
    }

    // Queue operation: Dequeue a ball (remove from the front)
    public String dequeue() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return null;
        }
        String value = head.value;
        head = head.next; // Remove the first node
        if (head == null) {
            tail = null; // If the list becomes empty
        }
        return value;
    }

    // Get the current ball
    public String getCurrentBall() {
        return (currentNode != null) ? currentNode.value : null;
    }

    // Get the previous ball in the list (iterates to find it)
    public String getPreviousBall() {
        if (currentNode == head || currentNode == null) {
            return null; // No previous ball exists
        }

        Node temp = head;
        while (temp != null && temp.next != currentNode) {
            temp = temp.next;
        }
        return (temp != null) ? temp.value : null;
    }

    // Get the next ball in the list
    public String getNextBall() {
        return (currentNode != null && currentNode.next != null) ? currentNode.next.value : null;
    }

    // Move to the next ball in the list
    public void moveNext() {
        if (currentNode != null && currentNode.next != null) {
            currentNode = currentNode.next;
        } else {
            System.out.println("Already at the last ball.");
        }
    }

    // Move to the previous ball in the list (iterates to find it)
    public void movePrevious() {
        if (currentNode == head || currentNode == null) {
            System.out.println("Already at the first ball.");
            return;
        }

        Node temp = head;
        while (temp != null && temp.next != currentNode) {
            temp = temp.next;
        }

        if (temp != null) {
            currentNode = temp;
        }
    }

    // Print all balls in the linked list
    public void printBalls() {
        System.out.println("Balls in the linked list:");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
