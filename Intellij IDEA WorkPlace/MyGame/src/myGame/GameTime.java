package myGame;

import javax.swing.Timer;


public class GameTime {

    static int TimeInteger;

    static Timer timer = new Timer(100, e -> {
        GameUtil.TimeNow = System.currentTimeMillis();
        GameUtil.GameTime += (int)(GameUtil.TimeNow - GameUtil.TimeBegin);
        GameUtil.TimeBegin = GameUtil.TimeNow;
        if(GameUtil.GameTime - TimeInteger * 1000 > 1000) {
            JPanelFunction.jPanelFunction.revalidate();
            JPanelFunction.jPanelFunction.repaint();
            TimeInteger = GameUtil.GameTime / 1000;
        }
    });

    static void TimeStart(){
        GameUtil.TimeBegin = System.currentTimeMillis();
        TimeInteger = GameUtil.GameTime / 1000;
        timer.start();

    }
    static void TimeStop(){
        timer.stop();


    }

}
