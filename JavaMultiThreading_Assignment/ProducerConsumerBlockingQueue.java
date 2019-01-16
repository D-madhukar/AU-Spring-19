import java.util.concurrent.*;
class Producer implements Runnable{
    BlockingQueue<String> queue;
    Producer( BlockingQueue<String> queue){
        this.queue=queue;
    }
    public void run(){
        for(int i=1;i<100;i++){
            String s="msg"+i;
            try{
//                queue.offer(s,1000,TimeUnit.MILLISECONDS);
            	  queue.put(s);
            	  Thread.sleep(1000);  
                  System.out.println(s+" produced");
            }
            catch(Exception e){}
        }
        try{queue.put("exit");}
        catch(Exception e){}       
    }

}
class Consumer implements Runnable{
    BlockingQueue<String> queue;
    Consumer( BlockingQueue<String> queue){
        this.queue=queue;
    }
    public void run(){
        while(true){
            try{    
//              String s=queue.poll(2000,TimeUnit.MILLISECONDS);
            	String s=queue.take();
                if(s.equals("exit"))
                    break;
                System.out.println(s+" consumed");
                Thread.sleep(5000);
            }
            catch(Exception e){}
        }
    }

}
public class ProducerConsumerBlockingQueue{
    public static void main(String args[]){
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(4);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        Thread t1=new Thread(producer);
        Thread t2=new Thread(consumer);
        t1.start();
        t2.start();
        System.out.println("Threads are started");
    }
}