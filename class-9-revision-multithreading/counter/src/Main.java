// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(new IncrementThread(sharedResource));
        Thread thread2 = new Thread(new IncrementThread(sharedResource));

        thread1.start();
        thread2.start();

        try {
           thread1.join();
           thread2.join();

            //Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + sharedResource.getCounter());//10
    }

}