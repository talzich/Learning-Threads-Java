
class MyTask implements Runnable{

    @Override
    public void run(){
        for (int i = 1; i <= 100; i++) {
            System.out.println("Printing Document #" + i + " from printer 2");
        }
    }
}


public class App {

    // main method represents the main threads
    public static void main(String[] args) {
        // whatever we write in here will be executed by the main thread

        // as we can see by the output order, threads always execute their jobs in a sequence
        System.out.println("== Application Started ==");


        // Job 1
        //task.executeTask --> Before MyTask was a thread
        Runnable r = new MyTask();
        Thread task = new Thread(r);
        task.start();

        // Job 2
        for (int doc = 1; doc <= 100; doc++) {
            System.out.println("Printing Document #" +doc+ " from printer 1");
        }

        //Job 3
        System.out.println("== Application Finished ==");

    }
}
