import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class ThreadLimitTest {
    public static void main(String[] args) {
        var threadCount = new AtomicInteger(0);
        try{
            while(true){
                var thread = new Thread(()->{
                    threadCount.incrementAndGet();
                    LockSupport.park();
                });
                thread.start();
            }
        }catch(OutOfMemoryError err){
            System.out.println("Reached thread Limit : "+ threadCount);
            err.printStackTrace();
        }
    }
}
