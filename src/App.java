
class MyTask extends Thread{

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


        // In this scenario, job 3 will not execute if job 2 is not a separate Thread. So lets create one
        // Job 1
        for (int doc = 1; doc <= 10; doc++) {
            System.out.println("Printing Document #" +doc+ " from printer 1");
        }

        // Job 2
        MyTask task = new MyTask();
        //task.executeTask --> Before MyTask was a thread
        task.start();

        //Job 3
        System.out.println("== Application Finished ==");

    }
}
