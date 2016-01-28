import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading {
//    public static void main(String[] args) throws InterruptedException {
////        Worker worker1 = new Worker(5);
////        Thread t1_1 = new Thread(worker1, "Thread 1 Worker 1");
////        Thread t2_1 = new Thread(worker1, "Thread 2 Worker 1");
////
////        Thread t3_2 = new Thread(new Worker(7), "Thread 3 Worker 2");
////        Thread t4_3 = new Thread(new Worker(7), "Thread 4 Worker 3");
////
////        t1_1.start();
////        t2_1.start();
////        t3_2.start();
////        t4_3.start();
//
//
//
//        Incr incr = new Incr(1);
////        Thread thread1 = new Thread(incr,"t1");
////        Thread thread2 = new Thread(incr,"t2");
////        Thread thread3 = new Thread(incr,"t3");
////        Thread thread4 = new Thread(incr,"t4");
////
////        thread1.start();
////        thread2.start();
////        thread3.start();
////        thread4.start();
//
//        Runnable task1 = () ->{
//            incr.incrNum();
//            System.out.println("=== finished ===");
//        };
//        Runnable task2 = () ->{
//            incr.incrNum();
//            System.out.println("=== finished ===");
//            incr.lock.unlock();
//        };
//
////        Thread thread1 = new Thread(task1, "Thread 1");
////        thread1.start();
////        Thread thread2 = new Thread(task2, "Thread 2");
////        thread2.start();
//
//
//
//        ExecutorService executorService = Executors.newWorkStealingPool();
//        executorService.submit(task1);
//        executorService.submit(task2);
//        executorService.submit(task1);
//        executorService.submit(task2);
//        executorService.submit(task1);
//        executorService.submit(task2);
//        executorService.submit(task1);
//        executorService.submit(task2);
//        executorService.submit(task1);
//        executorService.submit(task2);
//        executorService.submit(task1);
//        executorService.submit(task2);
//        executorService.submit(task1);
//        executorService.submit(task2);
//        executorService.submit(task1);
//        executorService.submit(task2);
//
//        executorService.shutdown();
//
//        Thread.sleep(5000);
//        task1.run();
//    }
    public static void main(String[] args) {
        TaskExecutor taskExecutor = new TaskExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable addTask1 = () ->{
            taskExecutor.insertTask();
        };
        Runnable addTask2 = () ->{
            taskExecutor.insertTask();
        };
//        Runnable addTask3 = () ->{
//            taskExecutor.insertTask();
//        };

        Runnable executeTask1 = () ->{
            taskExecutor.executeTask();
        };
        Runnable executeTask2 = () ->{
            taskExecutor.executeTask();
        };
        Runnable executeTask3 = () ->{
            taskExecutor.executeTask();
        };

        executorService.submit(addTask1);
        executorService.submit(addTask2);
//        executorService.submit(addTask3);

        executorService.submit(executeTask1);
        executorService.submit(executeTask2);
        executorService.submit(executeTask3);


//        System.out.println(TaskExecutor.count);


//        executorService.submit(() -> {
//            System.out.println(Thread.currentThread().getName());
//            System.out.println("lol");
//        });
    }
}
