package Helpers;

import java.util.concurrent.locks.Condition;

interface Check {

    public boolean checkWhat(Condition condition);

}

public class Awaiter {

    public int SecondsTimeout;

    public void AwaitAction(Check runAction, Condition condition)
            throws InterruptedException {
        //Check check = (a1, a2) -> {return a1 == a2;};
        //boolean result = check.checkWhat(2 == 5);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("0");
                method();
                //boolean result = runAction.checkWhat();
            }
        });
        thread.start();
        long endTimeMillis = System.currentTimeMillis() + 10000;
        while (thread.isAlive()) {
            if (System.currentTimeMillis() > endTimeMillis) {
                System.out.println("1");
                break;
            }
            try {
                System.out.println("2");
                Thread.sleep(500);
            }
            catch (InterruptedException t) {}
        }
    }

    static void method() {
        long endTimeMillis = System.currentTimeMillis() + 10000;
        while (true) {
            // method logic
            System.out.println("3");
            if (System.currentTimeMillis() > endTimeMillis) {
                // do some clean-up
                System.out.println("4");
                return;
            }
        }
    }




}
