import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tasks {
    /**
     * Write a small program ThreadClass.java that takes any positive integer
     * (y) from user input (command line) and creates exactly y threads and display their
     * own name.
     *
     * Sample Input: 3
     *
     * Sample Output:
     * Hello, this is "Yourname" #1
     * Hello, this is "Yourname" #2
     * Hello, this is "Yourname" #3
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine()
                ;
        System.out.println("Enter a positive integer: ");
        int y;
        try {
            y = scanner.nextInt();
            if (y <= 0) {
                System.out.println("Please enter a positive integer.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a positive number.");
            return;
        } finally {
            scanner.close();
        }

        ExecutorService executorService = Executors.newFixedThreadPool(y);

        for (int i = 1; i <= y ; i++) {
            executorService.submit(new Task(name, i));
        }
        executorService.shutdown();
    }

    static class Task implements Runnable {
        private  String name;
        private int threadNumber;

        public Task(String name, int threadNumber) {
            this.name = name;
            this.threadNumber = threadNumber;
        }

        @Override
        public void run() {
            /**
             * Short-lived tasks
             */
            System.out.println("Hello, this is \"" + name + "\" #" + threadNumber);
        }
    }
}
