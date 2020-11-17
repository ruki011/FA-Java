package task2;

public class SuncThread  extends Thread{
    private Object lock;

    public SuncThread(Object object){
        lock = object;
    }

    public void run(){
        synchronized (lock){
            try {
                System.out.println(getName());
                lock.notify();
                lock.wait();
            }catch (InterruptedException e){
                lock.notify();
            }

        }
    }
}
