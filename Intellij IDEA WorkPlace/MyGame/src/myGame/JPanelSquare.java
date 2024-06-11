package myGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class JPanelSquare extends JPanel {


    int x, y;
    boolean over;


    public JPanelSquare(int x, int y){
        super();
        this.x = x;
        this.y = y;


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(!GameUtil.overCommand &&
                        e.getButton() == MouseEvent.BUTTON1 &&
                        e.getX() > 0 &&
                        e.getX() < GameUtil.SQUARE_LENGTH &&
                        e.getY() > 0 &&
                        e.getY() <GameUtil.SQUARE_LENGTH &&
                        GameUtil.DataTop[y][x] == 0) {
                    if(!GameFrame.firstClick){
                        MineCreate.createMines(x, y);
                        BottomNum.Crate();
                        GameFrame.firstClick = true;
                        GameTime.TimeStart();
                    }
                    SpaceOpen();
                }
                if(!GameUtil.overCommand &&
                        e.getButton() == MouseEvent.BUTTON3 &&
                        e.getX() > 0 &&
                        e.getX() < GameUtil.SQUARE_LENGTH &&
                        e.getY() > 0 &&
                        e.getY() <GameUtil.SQUARE_LENGTH) {
                    if(GameUtil.DataTop[y][x] == 0) {
                        if(GameUtil.leftMine > 0) {
                            GameUtil.DataTop[y][x] = 2;
                            GameUtil.leftMine--;
                            JPanelFunction.jPanelFunction.revalidate();
                            JPanelFunction.jPanelFunction.repaint();
                        }
                    }
                    else if(GameUtil.DataTop[y][x] == 2) {
                        GameUtil.DataTop[y][x] = 0;
                        GameUtil.leftMine++;
                        JPanelFunction.jPanelFunction.revalidate();
                        JPanelFunction.jPanelFunction.repaint();
                    }
                    if(GameUtil.DataTop[y][x] == 1) {
                        int count = 0;
                        for(int i = -1; i < 2; i++) {
                            for(int j = -1; j < 2; j++) {
                                if(GameUtil.DataTop[y + i][x + j] == 2) count++;
                            }
                        }
                        if(count == GameUtil.DataBottom[y][x]) {
                            int numOfGame = GameUtil.NumberOfGames;
                            int[][] shift = {{1,0},{0,1},{0,-1},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
                            for (int i = 0; i < 8; i++) {
                                if (y + shift[i][0] > 0 &&
                                        y + shift[i][0] <= GameUtil.SquareHeightNum &&
                                        x + shift[i][1] > 0 &&
                                        x + shift[i][1] <= GameUtil.SquareWidthNum &&
                                        GameUtil.DataTop[y + shift[i][0]][x + shift[i][1]] == 0 &&
                                        numOfGame == GameUtil.NumberOfGames) {
                                    TopMap.topMap.squarePanels[y + shift[i][0] - 1][x + shift[i][1] - 1].SpaceOpen();
                                }
                            }
                        }
                    }
                }
                revalidate();
                repaint();
            }
        });

    }



    public void SpaceOpen() {
        int numOfGame = GameUtil.NumberOfGames;
        if(GameUtil.DataTop[y][x] == 0){

            over = GameEndJudgment.isFailure(x, y);
            if(over) return;
            this.setOpaque(false);
            this.revalidate();
            this.repaint();
            GameUtil.DataTop[y][x] = 1;
            TopMap.topMap.LeftNonMineNum--;
            if(TopMap.topMap.LeftNonMineNum == 0) this.over = GameEndJudgment.isWin();
            if(over) {
                return;
            }
            if(GameUtil.DataBottom[y][x] == 0) {
                int[][] shift = {{1,0},{0,1},{0,-1},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};//偏移量
                for (int i = 0; i < 8; i++) {
                    if (y + shift[i][0] > 0 &&
                            y + shift[i][0] <= GameUtil.SquareHeightNum &&
                            x + shift[i][1] > 0 &&
                            x + shift[i][1] <= GameUtil.SquareWidthNum &&
                            GameUtil.DataTop[y + shift[i][0]][x + shift[i][1]] == 0 &&
                            numOfGame == GameUtil.NumberOfGames) {
                        TopMap.topMap.squarePanels[y + shift[i][0] - 1][x + shift[i][1] - 1].SpaceOpen();
                    }
                }
            }
        }

        revalidate();
        repaint();

    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
            if(GameUtil.DataTop[y][x] == 0) g.drawImage(GameUtil.NoFlagImage, 0, 0, width, height, null);
        if(GameUtil.DataTop[y][x] == 1) this.setOpaque(false);
        if(GameUtil.DataTop[y][x] == 2) g.drawImage(GameUtil.FlagImage, 0, 0, width, height, null);

    }
}
