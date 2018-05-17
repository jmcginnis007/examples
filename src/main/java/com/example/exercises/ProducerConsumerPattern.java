package com.example.exercises;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerPattern {

    public static void main(String args[]){
  
     //Creating shared object
     BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
 
     //Creating Producer and Consumer Thread
     Thread prodThread = new Thread(new ProducerClass(sharedQueue),"producerThread");
     Thread consThread = new Thread(new ConsumerClass(sharedQueue), "consumerThread");

     //Starting producer and Consumer thread
     prodThread.start();
     consThread.start();
    }
 
}

class ProducerClass implements Runnable {

    private final BlockingQueue<Integer> sharedQueue;

    public ProducerClass(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

class ConsumerClass implements Runnable{

    private final BlockingQueue<Integer> sharedQueue;

    public ConsumerClass (BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
  
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Consumed: "+ sharedQueue.take());
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
}

