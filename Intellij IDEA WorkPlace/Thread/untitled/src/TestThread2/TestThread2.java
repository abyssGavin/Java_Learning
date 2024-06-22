package TestThread2;


public class TestThread2 implements Runnable{
    public void run() {
        for(int i = 0; i < 1000; i++) {
            System.out.println("*****"+i);
        }
    }

    public static void main(String[] args) {
        TestThread2 testThread2 = new TestThread2();
        Thread thread = new Thread(testThread2);
        thread.start();

        for(int i = 0 ; i < 1000; i++) {
            System.out.println("___________"+i);
        }
    }
}
