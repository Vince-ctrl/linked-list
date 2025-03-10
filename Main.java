public class Main {
    public static void main(String[] args) {
        // Create a bucket with balls of different colors
        String[] ballColors = {"Red", "Blue", "Green", "Yellow"};
        Bucket bucket = new Bucket(ballColors);

        // Print all balls
        bucket.printBalls();

        // Display current, previous, and next balls
        System.out.println("Current ball: " + bucket.getCurrentBall());
        System.out.println("Next ball: " + bucket.getNextBall());
        System.out.println("Previous ball: " + bucket.getPreviousBall());

        // Move to the next ball and display again
        bucket.moveNext();
        System.out.println("\nAfter moving to the next ball:");
        System.out.println("Current ball: " + bucket.getCurrentBall());
        System.out.println("Next ball: " + bucket.getNextBall());
        System.out.println("Previous ball: " + bucket.getPreviousBall());
    }
}
