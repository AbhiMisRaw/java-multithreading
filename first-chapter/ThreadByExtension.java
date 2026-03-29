class ThreadByExtension extends Thread{
    public ThreadByExtension(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("Extended Thread : "+ getName());
    }
}