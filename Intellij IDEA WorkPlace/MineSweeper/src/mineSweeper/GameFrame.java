package mineSweeper;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    static GameFrame Game = new GameFrame("扫雷");
    JPanel root;
    static boolean firstClick;
    static int widthSquareNum;
    static int heightSquareNum;
    static int mineNum;

    GameFrame(String Title){
        super(Title);

    }

    void initializeGame(){
        root = new JPanel();
        this.setContentPane(root);
        root.setVisible(true);
        root.setLayout(new LayoutFrame());
        this.setSize(GameUtil.MapWidth, GameUtil.MapHeight);
        this.setLocationRelativeTo(null);//固定窗口位置
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void GameLaunch(){

        JDialogOption.setJDialogOption(this);
    }

    void launch(){


        GameUtil.SetUtil(widthSquareNum, heightSquareNum, mineNum);
        BottomMap.setBottomMap();
        TopMap.setTopMap();
        root.add(BottomMap.bottomMap);
        this.setSize(GameUtil.FrameWidth, GameUtil.FrameHeight);
        BottomMap.bottomMap.setPreferredSize(new Dimension(GameUtil.MapWidth, GameUtil.MapHeight));
        this.setLocationRelativeTo(null);//固定窗口位置居中
        this.setResizable(false);//固定窗口大小
        TopMap.topMap.setSquarePanels();//格子的设置
        JPanelFunction.setJPanelFunction();

        firstClick = false;







    }


}
