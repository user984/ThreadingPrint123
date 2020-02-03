package threading.t2;

public class NumberPrintThread implements Runnable
{
    SharedData sharedData;
    NumberPrintThread(SharedData tdd) {
        this.sharedData = tdd;
    }

    @Override
    public void run()
    {
        //final String tname = Thread.currentThread().getName();
        System.out.println("Starting run method for thread: " + Thread.currentThread().getName());
            while(true) {
                synchronized (sharedData) {
                    while (!sharedData.getCheckFlag().equals(
                            sharedData.threadNameCheckFlag.get(Thread.currentThread().getName()))) {
                        try {
                            sharedData.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    sharedData.incrementAil(1);
                    sharedData.setCheckFlag((sharedData.threadNameCheckFlag.get(Thread.currentThread().getName()) + 1) % 3);
                    System.out.println("Result" + "(" + Thread.currentThread().getName() + ")" + sharedData.getAi1());
                    sharedData.notifyAll();
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        //System.out.println("Value of a1 " + threadData.getAi1());
        //System.out.println("Ending run method for thread: " + Thread.currentThread().getName());
    }
}
