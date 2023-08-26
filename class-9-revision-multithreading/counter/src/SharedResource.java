public class SharedResource {
    private int counter = 0;

    // Method synchronized to ensure mutual exclusion
    public synchronized void  incrementCounter() {
        int temp = counter;

        temp++;
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        counter = temp;
        System.out.println(Thread.currentThread().getName()+ " : " + counter);
    }

    public int getCounter() {
        return counter;
    }
}
