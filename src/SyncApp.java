class Printer{

    void printDocuments(int numOfCopies, String docName){
        for (int i = 1; i <=10 ; i++) {
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
        pRef.printDocuments(10, "TalsProfile.pdf");
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
        Printer print = new Printer();
        //print.printDocuments(10, "myDocument"); --> If we didn't have a thread to work with

        // In this scenario we have multiple threads working on the same Printer Object
        // This will cause de-synchronization
        MyThread mRef = new MyThread(print);  // MyThread has a reference to the Printer Object
        YourThread yRef = new YourThread(print); // Your Thread has a reference to the Printer Object

        mRef.start();
        yRef.start();

        System.out.println("=== Application Finished ===");
    }
}
