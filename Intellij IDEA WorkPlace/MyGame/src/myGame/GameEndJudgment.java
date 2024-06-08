package myGame;

import javax.swing.*;

public class GameEndJudgment {

    static public JOptionPane WinFailureJOptionPane = new JOptionPane();

    private GameEndJudgment() {

    }

    static boolean isWin(){


//        for(int i = 1; i < GameUtil.SquareWidthNum; i++) {
//            for(int j = 1; j < GameUtil.SquareHeightNum; j++){
//                if(GameUtil.DataBottom[i][j] != -1){
//                    TopMap.topMap.squarePanels[i - 1][j - 1].setOpaque(false);
//                    TopMap.topMap.squarePanels[i - 1][j - 1].revalidate();
//                    TopMap.topMap.squarePanels[i - 1][j - 1].repaint();
//                }
//            }
//        }
        GameTime.TimeStop();
        GameUtil.overCommand = true;
        int response = JOptionPane.showConfirmDialog(WinFailureJOptionPane, "你赢了！！！是否再来一局", "包赢的", JOptionPane.YES_NO_OPTION);
        if(response == JOptionPane.YES_OPTION) GameFrame.Game.launch();
        return true;
    }

    static boolean isFailure(int x, int y) {
        if (GameUtil.DataBottom[y][x] == -1) {
            GameTime.TimeStop();
            GameUtil.DataWrong[y][x] = true;
            for (int i = 1; i <= GameUtil.SquareHeightNum; i++) {
                for (int j = 1; j <= GameUtil.SquareWidthNum; j++) {
                    if (GameUtil.DataTop[i + 1][j + 1] == 2 && GameUtil.DataBottom[i + 1][j + 1] != -1) {
                        GameUtil.DataWrong[i][j] = true;
                        GameUtil.overCommand = true;


                    }
                }
            }
            TopMap.topMap.setSquarePanelsOpaque(false);
            int response = JOptionPane.showConfirmDialog(WinFailureJOptionPane, "你输了！！！是否再来一局", "不要给阿哈看扁了", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) GameFrame.Game.launch();
            return true;
        }
        return false;
    }
    static boolean isOverTime() {

        GameTime.TimeStop();

        GameUtil.overCommand = true;
//        TopMap.topMap.setSquarePanelsOpaque(false);
        int response = JOptionPane.showConfirmDialog(WinFailureJOptionPane, "你超时了", "时间就是金钱", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) GameFrame.Game.launch();

        return false;
    }

}
