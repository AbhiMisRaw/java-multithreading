public class First{
    public static void main(String[] arg){
        System.out.println("==== Starting Thread ====");
        Thread t1 = new ThreadByExtension("Worker-1");
        t1.start();

        Thread t2 = new Thread(new RunnableImpl(), "Worker-2");
        t2.start();

        Thread t3 = new Thread(
            new Runnable() {
                public void run(){
                    System.out.println("Anonymous: "+ Thread.currentThread().getName());
                }
            }, "Worker-3"
        );
        t3.start();

        Thread t4 = new Thread(
            ()->System.out.println("Lambda :"+Thread.currentThread().getName())
        , "Worker-4");
        t4.start();
    }

}