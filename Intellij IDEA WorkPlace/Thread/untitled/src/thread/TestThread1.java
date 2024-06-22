package thread;

public class TestThread1 extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            System.out.println("*****"+i);
        }
    }

    public static void main(String[] args) {
        TestThread1 testThread1 = new TestThread1();
        testThread1.start();
        for(int i = 0 ; i < 1000; i++) {
            System.out.println("___________"+i);
        }
    }

}
