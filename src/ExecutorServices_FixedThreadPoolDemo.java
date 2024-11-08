import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServices_FixedThreadPoolDemo {
    public static void main(String[] args) {
        /**
         * Get the count of available cores
         */
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        /**
         * Submit the tasks for execution
         */
        for (int i = 0; i < 100; i++) {
            service.execute(new CpuIntensiveTask());
        }
    }

    static class CpuIntensiveTask implements Runnable {
        @Override
        public void run() {
            /**
             * Some cpu intensive operations
             */
            System.out.println("Thread Name: "+Thread.currentThread().getName());
        }
    }
}