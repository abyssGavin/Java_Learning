package myGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BottomMap extends JPanel {

    public static BottomMap bottomMap = new BottomMap();

    private BottomMap(){
        this.setLayout(new LayoutBottomMap());

        setFocusable(true);  // 确保JPanel可以接收到键盘事件

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_T && !GameUtil.overCommand && GameFrame.firstClick) {
                    boolean nonRealization = true;
                    System.out.println(("WA!"));
                    int count = 0;
                    for(int i = 0; i < GameUtil.SquareHeightNum; i++) {
                        for(int j = 0; j < GameUtil.SquareWidthNum; j++){
                            if(GameUtil.DataTop[i + 1][j + 1] == 0 && GameUtil.DataBottom[i + 1][j + 1] == 0) {
                                count++;
                            }
                        }
                    }
                    if(count != 0) {
                        count = (int) (Math.random() * count) + 1;
                        for(int i = 0; i < GameUtil.SquareHeightNum; i++) {
                            for(int j = 0; j < GameUtil.SquareWidthNum; j++){
                                if(GameUtil.DataTop[i + 1][j + 1] == 0 && GameUtil.DataBottom[i + 1][j + 1] == 0) {
                                    count--;
                                }
                                if(count == 0) {
                                    TopMap.topMap.squarePanels[i][j].SpaceOpen();
                                    return;
                                }
                            }

                        }
                    }else {
                        for(int i = 0; i < GameUtil.SquareHeightNum; i++) {
                            for(int j = 0; j < GameUtil.SquareWidthNum; j++){
                                if(GameUtil.DataTop[i + 1][j + 1] == 0 && GameUtil.DataBottom[i + 1][j + 1] >= 0) {
                                    count++;
                                }
                            }
                        }
                        if(count == 0) return;
                        else{
                            count = (int) (Math.random() * count) + 1;
                            for(int i = 0; i < GameUtil.SquareHeightNum; i++) {
                                for(int j = 0; j < GameUtil.SquareWidthNum; j++){
                                    if(GameUtil.DataTop[i + 1][j + 1] == 0 && GameUtil.DataBottom[i + 1][j + 1] >=0) {
                                        count--;
                                    }
                                    if(count == 0) {
                                        TopMap.topMap.squarePanels[i][j].SpaceOpen();
                                        return;
                                    }
                                }

                            }
                        }

                    }
                }
            }
        });
    }


    public static void setBottomMap(){
        bottomMap = new BottomMap();
    }






    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        g.setColor(new Color(192,192,192));
        g.fillRect(0, 0, width, height);

        g.setColor(new Color(198,198,198));
        g.fillRect(GameUtil.OFFSET_LEFT,
                GameUtil.OFFSET_TOP,
                GameUtil.SquareWidthNum * GameUtil.SQUARE_LENGTH,
                GameUtil.SquareHeightNum * GameUtil.SQUARE_LENGTH);



        //竖线
        for (int i = 0; i <= GameUtil.SquareWidthNum; i++) {
            for(int j = 0; j < 4; j++) {
                g.setColor(new Color(100 + j * 30, 100 + j * 30, 100 + j * 30));

                g.drawLine(GameUtil.SQUARE_LENGTH * i + GameUtil.OFFSET_LEFT + 1 - j,
                        GameUtil.OFFSET_TOP,
                        GameUtil.SQUARE_LENGTH * i + GameUtil.OFFSET_LEFT  + 1 - j,
                        GameUtil.SQUARE_LENGTH * GameUtil.SquareHeightNum + GameUtil.OFFSET_TOP);
            }
        }
        //横线
        for (int i = 0; i <= GameUtil.SquareHeightNum; i++) {
            for(int j = 0; j < 4; j++) {
                g.setColor(new Color(100 + j * 30, 100 + j * 30, 100 + j * 30));
                g.drawLine(GameUtil.OFFSET_LEFT,
                        GameUtil.SQUARE_LENGTH * i + GameUtil.OFFSET_TOP + 1 -j,
                        GameUtil.SQUARE_LENGTH * GameUtil.SquareWidthNum + GameUtil.OFFSET_LEFT,
                        GameUtil.SQUARE_LENGTH * i + GameUtil.OFFSET_TOP + 1 - j);

            }
        }
        for(int i = 0; i < 8; i++) {
            g.setColor(new Color(123,123,123));
            g.drawLine(GameUtil.OFFSET_LEFT - i, GameUtil.OFFSET_TOP - i, GameUtil.OFFSET_LEFT - i, GameUtil.OFFSET_TOP + GameUtil.SquareHeightNum * GameUtil.SQUARE_LENGTH + i);
            g.drawLine(GameUtil.OFFSET_LEFT - i, GameUtil.OFFSET_TOP - i, GameUtil.OFFSET_LEFT + GameUtil.SquareWidthNum * GameUtil.SQUARE_LENGTH + i, GameUtil.OFFSET_TOP - i);

            g.drawLine( GameUtil.MapWidth - i, i, GameUtil.MapWidth - i, GameUtil.MapHeight - i);
            g.drawLine(i, GameUtil.MapHeight - i, GameUtil.MapWidth - i, GameUtil.MapHeight - i);

            g.setColor(new Color(253,253,253 ));
            g.drawLine(GameUtil.OFFSET_LEFT + GameUtil.SquareWidthNum * GameUtil.SQUARE_LENGTH + i, GameUtil.OFFSET_TOP - i, GameUtil.OFFSET_LEFT + GameUtil.SquareWidthNum * GameUtil.SQUARE_LENGTH + i, GameUtil.OFFSET_TOP + GameUtil.SquareHeightNum * GameUtil.SQUARE_LENGTH + i);
            g.drawLine(GameUtil.OFFSET_LEFT - i, GameUtil.OFFSET_TOP + GameUtil.SquareHeightNum * GameUtil.SQUARE_LENGTH + i, GameUtil.OFFSET_LEFT + GameUtil.SquareWidthNum * GameUtil.SQUARE_LENGTH + i, GameUtil.OFFSET_TOP + GameUtil.SquareHeightNum * GameUtil.SQUARE_LENGTH + i);

            g.drawLine(i, 0, i, GameUtil.MapHeight - i );
            g.drawLine(0, i, GameUtil.MapWidth - i, i );
        }



        //雷和数字和叉叉的绘制
        for (int i = 0; i < GameUtil.SquareHeightNum; i++) {
            for (int j = 0; j < GameUtil.SquareWidthNum; j++) {
                if (GameUtil.DataBottom[i + 1][j + 1] == -1) {
                    g.drawImage(GameUtil.MineImage,
                            GameUtil.SQUARE_LENGTH * j + GameUtil.OFFSET_LEFT,
                            GameUtil.SQUARE_LENGTH * i + GameUtil.OFFSET_TOP,
                            GameUtil.SQUARE_LENGTH,
                            GameUtil.SQUARE_LENGTH,
                            null);
                }
                if (GameUtil.DataBottom[i + 1][j + 1] > 0) {


                    g.drawImage(GameUtil.NumColorfulImage[GameUtil.DataBottom[i + 1][j + 1]],
                            GameUtil.SQUARE_LENGTH * j + GameUtil.OFFSET_LEFT + 6,
                            GameUtil.SQUARE_LENGTH * i + GameUtil.OFFSET_TOP + 6,
                            GameUtil.SQUARE_LENGTH - 12,
                            GameUtil.SQUARE_LENGTH - 12,
                            null);
                }
                if(GameUtil.DataWrong[i + 1][j + 1]) {
                    g.drawImage(GameUtil.WrongImage,
                            GameUtil.SQUARE_LENGTH * j + GameUtil.OFFSET_LEFT + 6,
                            GameUtil.SQUARE_LENGTH * i + GameUtil.OFFSET_TOP + 6,
                            GameUtil.SQUARE_LENGTH - 12,
                            GameUtil.SQUARE_LENGTH - 12,
                            null);
                }


            }
        }

    }

}