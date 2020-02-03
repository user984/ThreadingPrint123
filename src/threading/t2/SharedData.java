package threading.t2;

import java.util.HashMap;
import java.util.Map;

public class SharedData
{
    Integer ai1 = 0;
    Integer checkFlag = 0;
    final Map<String, Integer> threadNameCheckFlag;
    //volatile Integer ai1 = 0;

    public SharedData()
    {
        threadNameCheckFlag = new HashMap<>();
        threadNameCheckFlag.put("t1", 0);
        threadNameCheckFlag.put("t2", 1);
        threadNameCheckFlag.put("t3", 2);
    }

    public Integer getAi1() {
        return ai1;
    }

    void incrementAil(Integer amount) {
        synchronized (this) {
            //System.out.println("Value of a1 by thread " + Thread.currentThread().getName() + " = " + this.getAi1() );
            this.ai1 += amount;
            //System.out.println("Value of a1 by thread " + Thread.currentThread().getName() + " = " + this.getAi1());
        }
    }

    public Integer getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Integer checkFlag) {
        synchronized (this) {
            this.checkFlag = checkFlag;
        }
    }
}
