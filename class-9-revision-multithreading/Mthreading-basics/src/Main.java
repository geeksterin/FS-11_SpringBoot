// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread());

        //TestC t1 = new TestC();
        //t1.start();

        TestI t2 = new TestI();
        //t2.run();

        Thread t22 = new Thread(t2);
        t22.start();

        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        try {
            t22.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Starting our test program!!!!");
    }
}