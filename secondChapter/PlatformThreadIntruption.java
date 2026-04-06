package secondChapter;

public class PlatformThreadIntruption {
   public static void main(String[] args)  {
    Thread platformThread = Thread.ofPlatform().start(()->{
        try {
            System.out.println("Platform Thread Started...");
            for (int i = 0; i < 5; i++) {
                System.out.println("Platform Thread Working : "+ i);
                Thread.sleep(1000);
                System.out.println("Platform Thread Completed : "+ i);
            }
            System.out.println("Platform Thread Finished...");
        } catch (InterruptedException e) {
            System.out.println("[[ WARNING ]] Platform Thread Intrupted ");
        }
    });
    try {
        Thread.sleep(2500);
    } catch (InterruptedException e) {}
    platformThread.interrupt();
   }
}
