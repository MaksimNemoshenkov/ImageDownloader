public class ThreadImgur extends Thread {

    @Override
    public void run(){
        new Main().downloadImgur();
    }
}
