public class TestThreadI implements Runnable{

    private void print()
    {
        System.out.println("Inside Test-Thread");

        System.out.println(Thread.currentThread());
        for(int i=0;i<10;i++)
        {
            System.out.println(i);
        }
        System.out.println("outside TestThreadI");
    }


    @Override
    public void run() {
        print();
    }
}
