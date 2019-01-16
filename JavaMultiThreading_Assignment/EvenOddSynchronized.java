class PrintEvenOdd{
    public synchronized void printEven(){
         while((Holder.n)%2==1){
            try{
                wait();
            }
            catch(InterruptedException ie){
                System.out.println(ie);
            }
        }
        System.out.println("Even number="+Holder.n);
        Holder.n+=1;
        notify();
    }
    public synchronized void printOdd(){
        while((Holder.n)%2==0){
            try{
                wait();
            }
            catch(InterruptedException ie){
                System.out.println(ie);
            }
        }
        System.out.println("odd number="+Holder.n);
        Holder.n+=1;
        notify();
    }
} 
class EvenThread  implements Runnable{
    PrintEvenOdd print;
    EvenThread(PrintEvenOdd print){
        this.print=print;
    }
    public void run(){
        for(int i=1;i<100;i++){
            print.printEven();
        }
    }
}
class Holder{
	static Integer n=1;
}

class OddThread  implements Runnable{
    PrintEvenOdd print;
    OddThread(PrintEvenOdd print){
        this.print=print;
    }
    public void run(){
        for(int i=1;i<100;i++){
            print.printOdd();
        }
    }
}

public class EvenOddSynchronized{
    public static void main(String arsg[])throws InterruptedException{
        PrintEvenOdd print=new PrintEvenOdd();
        Thread t=new Thread(new OddThread(print));
        Thread t1=new Thread(new EvenThread(print));
        t.start();
        t1.start();
        System.out.println("main thread terminated");
    }
}
