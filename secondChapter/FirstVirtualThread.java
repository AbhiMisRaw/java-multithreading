package secondChapter;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FirstVirtualThread {
    public static void main(String[] args) throws InterruptedException{
        Thread vThread = Thread.startVirtualThread(()->{
                System.out.println("Virtual Threads make concurrency efforless! "+
                    "See yourself."
                );
            });
        vThread.join();

        // Using Thread Builder API
        var startedThread = Thread.ofVirtual().start(
            ()-> System.out.println("Virtual thread from Thread Builder APIs | Started Thread")
        );

        // without starting it immediately
        var unstartedThread = Thread.ofVirtual().unstarted(
            ()-> System.err.println("Thread Builder API | Unstarted Thread")
        );


        // Using Executors Framework
        try(var virtualExecutor = Executors.newVirtualThreadPerTaskExecutor()){
            Future<String> future = virtualExecutor.submit(()->{
                System.out.println("Virtual Thread from Virtual Executor");
                return "Hello";
        });
        }
    }
}
