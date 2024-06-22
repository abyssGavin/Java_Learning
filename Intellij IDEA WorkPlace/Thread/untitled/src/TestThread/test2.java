package TestThread;

public class test2 implements Runnable{

    boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println("Run....Thread");
        }

    }

    public void stop(){
        this.flag = false;
    }



    public void test(){
        test2 test = new test2();
        new Thread(test).start();

        for(int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if(i == 900) {
                test.stop();
                System.out.println("stop");
            }
        }
    }

}
