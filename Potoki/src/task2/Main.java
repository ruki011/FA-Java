package task2;

public class Main {
    public static void main(String[] args){
        Object lock = new Object();
        new SuncThread(lock).start();
        new SuncThread(lock).start();

    }
}
