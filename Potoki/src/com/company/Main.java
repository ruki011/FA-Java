package com.company;

public class Main {
    private boolean isActive;

    void dissable(){
        isActive = false;
    }

    void NewThread2(){
        isActive = true;

    }

    public  static  void  main(String args){

        CommonResurse commonResurse = new CommonResurse();
        for(int i=1; i<5; i++){
            Thread t = new Thread(new CountThread(commonResurse), "Thread"+i);
            t.start();
        }
        System.out.println("Main thread finished");

        /*Thread t =Thread.currentThread();
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        t.isAlive();
        t.run();
        t.start();
        System.out.println("Main thread started...");
        for(int i=0; i<10;i++){
            new NewThread("Thread" +i).start();
        }
        NewThread2 nt = new NewThread2();
        NewThread t = new Thread(nt, "NewThread2");
        }
        nt.start();
        try {
            nt.dissable();
        }catch (InterruptedException e){
            System.out.println("%s has been int", t.getName());

        }
        new  NewThread("Thread1").start();
        System.out.println("Main threa finished");*/




    }
}
