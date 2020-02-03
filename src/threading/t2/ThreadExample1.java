package threading.t2;


public class ThreadExample1
{
    public static void main(String[] args)
    {
        SharedData td = new SharedData();
        Thread t1 = new Thread(new NumberPrintThread(td), "t1");
        Thread t2 = new Thread(new NumberPrintThread(td), "t2");
        Thread t3 = new Thread(new NumberPrintThread(td), "t3");

        System.out.println("Starting threads....");
        t1.start();
        t2.start();
        t3.start();

        System.out.println("Waiting for threads to finish....");
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(td.getAi1());
    }
}
