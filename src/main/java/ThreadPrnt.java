public class ThreadPrnt extends Thread{

    @Override
    public void run(){
        new Main().downloadPrnt();
    }
}
