import java.util.*;

public class TaskExecutor {
    public static int count = 0;

    public TaskExecutor() {
        count++;
    }

    private Object lock = new Object();
    private Queue<Integer> list = new LinkedList<>();
    private final int limit = 10;

    private synchronized void addTask(int elem){
        if(list.size() == limit){
            System.out.println("queue is full");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {

            list.add(elem);
            System.out.println("element " + elem + " added");
            notify();
        }
    }

    private synchronized int getTask() {

        if (list.size() == 0){
            System.out.println("queue is empty");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int elem = list.remove();
        System.out.println("element " + elem + " removed");
        notify();
        return elem;
    }

    public void executeTask(){
        while (true) {
//            System.out.println("execute method");
            int elem = getTask();
//            System.out.println("execute element " + elem);
            try {
                Thread.sleep((elem * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("element " + elem + " executed");
        }

    }

    public void insertTask(){
        while (true){
//            System.out.println("insert method");
            Integer elem = getRandom();
            addTask(elem);
        }
    }

    private Integer getRandom(){
        Random r = new Random();
        return r.nextInt(10);
    }
}
