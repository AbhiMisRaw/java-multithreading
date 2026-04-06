package secondChapter;

public class VirtualThreadIntruption {
    public static void main(String[] args) {
        Thread vThread = Thread.ofVirtual().start(()->{
            try {
                System.out.println("Virtual Thread Started....");
                for (int i = 0; i < 5; i++) {
                    System.out.println("Virtual Thread Executing... : "+ i);
                    Thread.sleep(1000);
                }
                System.out.println("Virtual thread Completed.");
            } catch (InterruptedException e) {
                System.out.println("Virtual Thread intrupted...");
            }
        });
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {}
        vThread.interrupt();
    }
}
