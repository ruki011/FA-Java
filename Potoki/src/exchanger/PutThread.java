package exchanger;
import java.util.concurrent.Exchanger;

public class PutThread implements Runnable {
    Exchanger<String> exchanger;
    String message;

    PutThread(Exchanger<String> ex){
        this.exchanger = ex;
        message = "we";

    }
    @Override
    public void run(){
        try {
            message = exchanger.exchange(message);
            System.out.println("Put Thread" + message);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
