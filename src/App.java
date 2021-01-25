public class App {

    // main method represents the main threads
    public static void main(String[] args) {
        // whatever we write in here will be executed by the main thread

        // as we can see by the output order, threads always execute their jobs in a sequence
        System.out.println("== Application Started ==");

        for (int doc = 1; doc <= 10; doc++) {
            System.out.println("Printing Document #" + doc);
        }

        System.out.println("== Application Finished ==");

    }
}
