public class Part3 extends Thread {
    private int counter;
    private int counter2;

    private int time;
    private int repeat;
    private int thread;

    private Thread[] threads;

    public Part3(int n, int k, int t) {
        this.thread = n;
        this.repeat = k;
        this.time = t;
        threads = new Thread[n];
    }

    public void test() {
        System.out.println("В тесте........................");
        for (int i = 0; i < thread; i++) {
            threads[i] = new Thread(this);
            System.out.println(counter + "................counter1");
            System.out.println(counter2 + "...............counter2");
            threads[i].start();
        }
    }

    @Override
    public void run() {
        System.out.println("В ране...................");
        for (int i = 0; i < repeat; i++) {
            counter++;
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter2++;
        }
    }
}
