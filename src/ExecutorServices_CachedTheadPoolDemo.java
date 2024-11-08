import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServices_CachedTheadPoolDemo {
    public static void main(String[] args) {
        /**
         * For a lot of short-lived task
         */
        ExecutorService service = Executors.newCachedThreadPool();

        /**
         * Submit the tasks for execution
         */
        for (int i = 0; i < 100; i++) {
            service.execute(new Task());
        }
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            /**
             * Short-lived tasks
             */
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        }
    }
}
