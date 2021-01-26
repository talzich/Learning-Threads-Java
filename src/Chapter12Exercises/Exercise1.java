package Chapter12Exercises;

public class Exercise1{

    static class Counter {
        int count;
        synchronized void inc() {
            count = count+1;
        }
        int getCount() {
            return count;
        }
    }
    static Counter c;

    static class Inc extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                c.inc();
            }
        }
    }


    public static void main(String[] args) {

        Inc[] workers = new Inc[2];
        c = new Counter();
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Inc();
        }
        for (int i = 0; i < workers.length; i++) {
            workers[i].start();
        }

        for (int i = 0; i < workers.length; i++) {
            try {
                workers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(c.getCount());

    }

}
