package com.company;

public class NewThread2 implements  Runnable{

    @Override
    public  void run(){
        System.out.printf("%s started\n", Thread.currentThread().getName());
        int counter = 1;
        while (isActive){
            System.out.println("Loop"+counter++);
            try {
                Thread.sleep(200);

            }catch (InterruptedException e){
                System.out.println("Thread has been interrapted");
            }
        }
    }
}
