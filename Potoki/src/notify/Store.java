package notify;

public class Store {
    private int product =0;

    public synchronized void get(){
        while (product<1){
            try {
                wait();
            }catch (InterruptedException e){}
        }
        product--;
        System.out.println("Клиент купилодин товар");
        System.out.printf("Товар на складе %d\n",product);
        notify();
    }

    public synchronized void put(){
        while (product >=3){
            try {
                wait();
            }catch (InterruptedException e){}
        }
        product++;
        System.out.println("Клиент купилодин товар");
        System.out.printf("Товар на складе %d\n",product);
        notify();
    }
}
