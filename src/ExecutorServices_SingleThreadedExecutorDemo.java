import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorServices_SingleThreadedExecutorDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            service.execute(new Task());
        }
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread Name: " + Thread.currentThread().getName());

        }
    }
}
