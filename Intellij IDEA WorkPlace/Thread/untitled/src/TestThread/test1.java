package TestThread;

public class test1 {
    int num = 100;

    public class TestThread implements Runnable{
        @Override
        public void run() {

            while(true){
                if(num <= 0) break;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + num--);
            }
        }
    }
    public void test(){
        TestThread testThread = new TestThread();

        new Thread(testThread, "第一个").start();
        new Thread(testThread, "第二个").start();
        new Thread(testThread, "第三个").start();

    }
}
