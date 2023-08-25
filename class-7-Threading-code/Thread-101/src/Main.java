// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread());
        TestThreadC tobj1 = new TestThreadC();
        TestThreadC tobj2 = new TestThreadC();
       // tobj1.run();
        tobj1.start();
        tobj2.start();
        System.out.println("At End of Code!!!!");

        //TestThreadI runTobj = new TestThreadI();
        //Thread ti1 = new Thread(runTobj);
        //ti1.start();
    }

}