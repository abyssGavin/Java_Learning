package TestThread;

public class test3 {

    public void test() throws InterruptedException {
        Thread thread = new Thread(()->{
            for(int i = 0; i < 5; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("WA!!!");
        });


        Thread.State state = thread.getState();
        System.out.println(state);


        thread.start();
        state = thread.getState();
        System.out.println(state);


        while(state != Thread.State.TERMINATED){
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }

    }



}
