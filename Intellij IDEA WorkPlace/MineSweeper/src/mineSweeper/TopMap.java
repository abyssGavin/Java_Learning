package mineSweeper;

import java.awt.*;

public class TopMap {

    public static TopMap topMap;
    JPanelSquare[][] squarePanels;
    public int LeftNonMineNum;

    public static void setTopMap(){
        topMap = new TopMap();
    }


    private TopMap(){

    }

    public void setSquarePanels(){
        squarePanels = new JPanelSquare[GameUtil.SquareHeightNum][GameUtil.SquareWidthNum];
        LeftNonMineNum = GameUtil.NonMineNum;
        for (int i = 0; i < GameUtil.SquareHeightNum; i++)
            for (int j = 0; j < GameUtil.SquareWidthNum; j++) {
                squarePanels[i][j] = new JPanelSquare(j + 1, i + 1);
                squarePanels[i][j].setVisible(true);
                squarePanels[i][j].setPreferredSize(new Dimension(GameUtil.SQUARE_LENGTH, GameUtil.SQUARE_LENGTH));
                BottomMap.bottomMap.add(squarePanels[i][j]);
                squarePanels[i][j].revalidate();
            }


    }

    public void setSquarePanelsOpaque(boolean bool) {
        if(!bool) {
            for (int i = 0; i < GameUtil.SquareHeightNum; i++)
                for (int j = 0; j < GameUtil.SquareWidthNum; j++) {
                    GameUtil.DataTop[i + 1][j + 1] = 1;
                    squarePanels[i][j].setOpaque(bool);
                    squarePanels[i][j].revalidate();
                    squarePanels[i][j].repaint();
                }


        }
    }

}
