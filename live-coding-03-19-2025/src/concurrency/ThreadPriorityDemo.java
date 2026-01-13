package concurrency;

public class ThreadPriorityDemo {
    public static void main(String[] args) {
        // Creating child tasks
        var childTask1 = new ChildTask();
        var childTask2 = new ChildTask();


        var t1 = new Thread(childTask1);
        var t2 = new Thread(childTask2);
        // Play with priorities
        var current = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " priority is " + current.getPriority());
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t1.getName() + " priority is " + t1.getPriority());
        System.out.println(t2.getName() + " priority is " + t2.getPriority());

        // Start Child Threads
        t1.start();
        t2.start();

        System.out.println(Thread.currentThread().getName() + " executed by main thread");
    }
}

class ChildTask implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " executed by child thread");
    }
}
