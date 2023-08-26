public class IncrementThread implements Runnable{
    private SharedResource sharedResource;

    public IncrementThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedResource.incrementCounter();
        }
        //System.out.println(sharedResource.getCounter());
    }
}
