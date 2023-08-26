public class TestC extends Thread{

   public void printNumber()
   {

       System.out.println(Thread.currentThread());
       for(int num = 1;num <= 10;num++)
       {
           System.out.println(num);
       }
   }

    @Override
    public void run() {
        printNumber();
    }
}
