public class Bucket {
    private String[] balls; // Array to store balls of different colors
    private int currentIndex; // Tracks the current position in the array

    // Constructor to initialize the bucket with an array of balls
    public Bucket(String[] balls) {
        this.balls = balls;
        this.currentIndex = 0; // Start at the first ball
    }

    // Get the current ball
    public String getCurrentBall() {
        if (currentIndex >= 0 && currentIndex < balls.length) {
            return balls[currentIndex];
        }
        return null; // Return null if the index is out of bounds
    }

    // Get the previous ball in the array
    public String getPreviousBall() {
        if (currentIndex > 0) {
            return balls[currentIndex - 1];
        }
        return null; // Return null if there is no previous ball
    }

    // Get the next ball in the array
    public String getNextBall() {
        if (currentIndex < balls.length - 1) {
            return balls[currentIndex + 1];
        }
        return null; // Return null if there is no next ball
    }

    // Move to the next ball in the array
    public void moveNext() {
        if (currentIndex < balls.length - 1) {
            currentIndex++;
        } else {
            System.out.println("Already at the last ball.");
        }
    }

    // Move to the previous ball in the array
    public void movePrevious() {
        if (currentIndex > 0) {
            currentIndex--;
        } else {
            System.out.println("Already at the first ball.");
        }
    }

    // Print all balls in the bucket
    public void printBalls() {
        System.out.println("Balls in the bucket:");
        for (String ball : balls) {
            System.out.println(ball);
        }
    }
}
