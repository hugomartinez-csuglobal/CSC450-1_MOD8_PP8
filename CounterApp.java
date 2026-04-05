public class CounterApp {

    // Function for Thread 1: Count up from 0 to 20
    public static void countUp() {
        for (int i = 0; i <= 20; i++) {
            System.out.println("Counting Up: " + i);
            try {
                Thread.sleep(200); // Pause for readability
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }

    // Function for Thread 2: Count down from 20 to 0
    public static void countDown() {
        for (int i = 20; i >= 0; i--) {
            System.out.println("Counting Down: " + i);
            try {
                Thread.sleep(200); // Pause for readability
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Starting Thread 1: Count Up");

        // Create Thread 1
        Thread thread1 = new Thread(() -> countUp());

        // Start Thread 1
        thread1.start();

        try {
            thread1.join(); // Wait for Thread 1 to finish
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("Thread 1 complete. Starting Thread 2: Count Down");

        // Create Thread 2
        Thread thread2 = new Thread(() -> countDown());

        // Start Thread 2
        thread2.start();

        try {
            thread2.join(); // Wait for Thread 2 to finish
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("Program complete");
    }
}