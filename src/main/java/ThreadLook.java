public class ThreadLook extends Thread{

    @Override
    public void run(){
        new Main().downloadLook();
    }

}
