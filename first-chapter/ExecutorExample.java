import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ExecutorExample {

    public static void main(String[] args) {
        
        // Try with resouces
        try(ExecutorService executor = Executors.newFixedThreadPool(5)){
            for (int i = 0; i < 10; i++) {
                final int taskId = i;
                executor.submit(()-> {
                        System.out.println("Executing Task : "+ taskId+" in Thread :"+ Thread.currentThread().getName());
                });
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
}
