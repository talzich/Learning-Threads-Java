import java.util.LinkedList;

class MyQueue{
    private LinkedList<String> myQueue = new LinkedList<>();
    private final int CAPACITY;

    public MyQueue(int capacity){
        this.CAPACITY = capacity;
    }

    public synchronized void put(String msg) throws InterruptedException {
        if(myQueue.size() == CAPACITY){
            wait();
        }

        myQueue.add(msg);
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        if(myQueue.size() == 0){
            wait();
        }
        String msg = myQueue.remove();
        notifyAll();
        return msg;
    }

}

public class WaitNotify {


}
