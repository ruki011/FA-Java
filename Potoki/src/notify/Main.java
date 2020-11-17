package notify;

public class Main {
    public static void main(String[] args){
        Store store = new Store();
        Produser produser = new Produser(store);
        Consumer consumer =new Consumer(store);
        new Thread(produser).start();
        new Thread(consumer).start();
    }
}
