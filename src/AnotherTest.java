
class SyncTest{
    synchronized static void foo1(){
        for (int i = 0; i < 1000000; i++) {
            System.out.println("foo1 " + Thread.currentThread().getName() +"\t"+ i);
        }
    }

    synchronized static void foo2(){
        for (int i = 0; i < 1000000; i++) {
            System.out.println("foo2 " + Thread.currentThread().getName() +"\t"+ i);
        }
    }
}

public class AnotherTest {

    public static void main(String[] args) {
        SyncTest a = new SyncTest();
        SyncTest b = new SyncTest();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                a.foo1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                b.foo2();
            }
        });
        t1.start();
        t2.start();

    }
}
