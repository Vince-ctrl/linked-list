import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();

        System.out.println("Welcome! Please enter items (e.g., tasks, names, etc.). Enter 'done' to finish:");

        // User inputs data
        while (true) {
            System.out.print("Enter item: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            linkedList.addBall(input);
        }

        System.out.println("\nItems added to the list.");
        linkedList.printBalls();

        // Display data as a queue
        System.out.println("\nDisplaying items as a Queue (FIFO):");
        LinkedList queueList = new LinkedList();
        while (true) {
            String item = linkedList.dequeue();
            if (item == null) {
                break;
            }
            System.out.println("Processing item (Queue): " + item);
            queueList.addBall(item); // Re-add to queue to preserve data for later steps
        }

        // Display data as a stack
        System.out.println("\nDisplaying items as a Stack (LIFO):");
        LinkedList stackList = new LinkedList();
        while (true) {
            String item = queueList.dequeue();
            if (item == null) {
                break;
            }
            stackList.push(item); // Add to stack
        }
        while (true) {
            String item = stackList.pop();
            if (item == null) {
                break;
            }
            System.out.println("Processing item (Stack): " + item);
        }

        // Real-world use case
        System.out.println("\nReal-world use case: Task management simulation.");
        LinkedList taskManager = new LinkedList();

        // Adding tasks based on user input
        taskManager.addBall("Complete project report");
        taskManager.addBall("Submit tax forms");
        taskManager.addBall("Prepare meeting agenda");
        taskManager.addBall("Respond to emails");

        System.out.println("\nTasks in the queue (regular tasks):");
        taskManager.printBalls();

        // Simulate processing regular tasks
        System.out.println("\nProcessing regular tasks:");
        while (true) {
            String task = taskManager.dequeue();
            if (task == null) {
                System.out.println("All regular tasks completed!");
                break;
            }
            System.out.println("Working on: " + task);
        }

        // Adding emergency tasks (stack behavior)
        taskManager.push("Fix critical bug");
        taskManager.push("Handle urgent client call");

        System.out.println("\nEmergency tasks added (stack behavior):");
        taskManager.printBalls();

        // Simulate processing emergency tasks
        System.out.println("\nHandling emergency tasks:");
        while (true) {
            String emergencyTask = taskManager.pop();
            if (emergencyTask == null) {
                System.out.println("All emergency tasks resolved!");
                break;
            }
            System.out.println("Resolving: " + emergencyTask);
        }

        scanner.close();
    }
}
