class Printer{

    synchronized void printDocuments(int numOfCopies, String docName){
        for (int i = 1; i <=10 ; i++) {
            try {

                Thread.sleep(50);// --> this will make each thread wait, but it still is not what we are looking for
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(">> Printing " +docName+ " " +i);
        }
    }
}
class MyThread extends Thread{

    Printer pRef;

    MyThread(Printer p){
        pRef = p;
    }

    @Override
    public void run(){
        synchronized (pRef) {
            pRef.printDocuments(10, "TalsProfile.pdf");
        }
    }
}

class YourThread extends Thread{
    Printer pRef;

    YourThread(Printer p){
        pRef = p;
    }

    @Override
    public void run(){
        pRef.printDocuments(10, "JohnsProfile.pdf");
    }
}
public class SyncApp {

    // main is representing main thread
    public static void main(String[] args) {
        System.out.println("=== Application Started ===");

        // We have a single Printer Object
        Printer printer1 = new Printer();
        //print.printDocuments(10, "myDocument"); --> If we didn't have a thread to work with

        // In this scenario we have multiple threads working on the same Printer Object
        // This will cause de-synchronization
        MyThread mRef = new MyThread(printer1);  // MyThread has a reference to the Printer Object
        YourThread yRef = new YourThread(printer1); // Your Thread has a reference to the Printer Object

        mRef.start();
//        This will work, but it will require us to add a .join method call to every .start method call. Inefficient

//        try {
//            mRef.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        yRef.start();

        System.out.println("=== Application Finished ===");
    }
}
