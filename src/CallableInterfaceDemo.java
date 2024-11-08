import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableInterfaceDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(10);

        /**
         * Will not work
         */
        //service.execute(new Task());

        /**
         * Submit the tasks for execution
         */
        //service.submit(new Task());

        /**
         * Future class is a placeholder for a value that will arrive
         * sometime in the future.
         *
         * Submit tasks for execution
         */
        Future<Integer> future = service.submit(new Task());

        //System.out.println("Thread Name: " + Thread.currentThread().getName());

        //System.out.println(future);
        Integer result = future.get();
        System.out.println(result);

        ExecutorService service2 = Executors.newFixedThreadPool(10);

        List<Future> allFutures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future<Integer> future2 = service2.submit(new Task());
            allFutures.add(future2);
        }

//        for (Future futures : allFutures) {
//            System.out.println(futures.get());
//        }

        for (int i = 0; i < 100; i++) {
            Future<Integer> future3 = allFutures.get(i);

            try {
                Integer resultFuture  = future3.get(1, TimeUnit.SECONDS); // blocking
                System.out.println("Result of future #" + i + " = " + resultFuture);
            } catch (InterruptedException e){
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println("Could not complete Task before timeout.");
            }
        }




    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }

}
