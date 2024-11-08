import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ExecutorServices_ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        /**
         * For scheduling tasks
         */
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        /**
         * Task to run after 10 seconds
         */
        service.schedule(new Task(), 10, SECONDS);

        /**
         * Task to run repeatedly every 10 seconds
         */
        service.scheduleAtFixedRate(new Task(),15,10, SECONDS);

        /**
         * Task to run repeatedly 10 seconds after previous task completes
         */
        service.scheduleWithFixedDelay(new Task(), 15,10, SECONDS);
    }

    static class Task implements  Runnable {
        @Override
        public void run() {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        }
    }
}
