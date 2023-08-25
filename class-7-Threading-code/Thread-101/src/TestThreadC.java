public class TestThreadC extends Thread{

    private  void print()
    {
        System.out.println("Inside Test-Thread");

        System.out.println(Thread.currentThread());
        for(int i=0;i<10;i++)
        {
            System.out.println(i + Thread.currentThread().getName());
          /*  try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Some exception happened!!!!");
            }*/
        }
        System.out.println("outside TestThreadC" + Thread.currentThread().getName());
    }

    @Override
    public synchronized void run() {
        print();
    }
}
