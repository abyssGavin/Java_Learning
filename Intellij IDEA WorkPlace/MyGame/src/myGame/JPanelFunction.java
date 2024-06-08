package myGame;

import javax.swing.*;
import java.awt.*;


public class JPanelFunction extends JPanel {

    static JPanelFunction jPanelFunction;
    float alpha_Change = 0.4f; // 透明度范围从0.0（完全透明）到1.0（完全不透明）
    AlphaComposite composite_Half = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha_Change);// AlphaComposite设置透明度
    float alpha = 1f; // 透明度范围从0.0（完全透明）到1.0（完全不透明）
    AlphaComposite composite_Opaque = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);// AlphaComposite设置透明度





    public JPanelFunction(int width, int height){
        this.setVisible(true);
        this.setPreferredSize(new Dimension(width, height));
        BottomMap.bottomMap.add(this);
        this.setLayout(new LayoutJPanelFunction());

    }

    public static void setJPanelFunction() {
        jPanelFunction = new JPanelFunction(GameUtil.MapWidth - GameUtil.OFFSET_LEFT - GameUtil.OFFSET_RIGHT + 16, GameUtil.OFFSET_TOP / 2 + 16);
        JPanelOption.setJPanelOption();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        int width = getWidth();
        int height = getHeight();
        g2d.setColor(new Color(193,193,193));
        g2d.fillRect(0, 0, width, height);


        for(int i = 0; i < 8; i++) {
            g2d.setColor(new Color(123,123,123));
            g2d.drawLine(0, i, width - i, i);
            g2d.drawLine(i, 0, i, height - i);
            g2d.setColor(new Color(253,253,253));
            g2d.drawLine(i, height - i, width - i, height - i);
            g2d.drawLine(width - i, i, width - i, height);

        }

        g2d.setColor(new Color(0,0,0));
        g2d.fillRect(GameUtil.SQUARE_LENGTH / 4 + 8 ,
                GameUtil.SQUARE_LENGTH / 4 + 8 ,
                GameUtil.SQUARE_LENGTH * 3,
                GameUtil.SQUARE_LENGTH * 3 / 2);
        g2d.fillRect(width - GameUtil.SQUARE_LENGTH / 4 - 8  - GameUtil.SQUARE_LENGTH * 3,
                GameUtil.SQUARE_LENGTH / 4 + 8 ,
                GameUtil.SQUARE_LENGTH * 3,
                GameUtil.SQUARE_LENGTH * 3 / 2);

        g2d.drawImage(GameUtil.NumColorfulImage[0], 5, 5, width / 3 - 10, height - 10, null);


        g2d.setComposite(composite_Half);
        // 绘制图像
        for(int i = 0; i < 3; i++) {
            g2d.drawImage(GameUtil.NumRedImage[8],
                    GameUtil.SQUARE_LENGTH / 4 + 8 + i * GameUtil.SQUARE_LENGTH,
                    GameUtil.SQUARE_LENGTH / 4 + 8, GameUtil.SQUARE_LENGTH,
                    GameUtil.SQUARE_LENGTH * 3 / 2,
                    this);
            g2d.drawImage(GameUtil.NumRedImage[8],
                    width - GameUtil.SQUARE_LENGTH / 4 - 8  - GameUtil.SQUARE_LENGTH * 3 + i * GameUtil.SQUARE_LENGTH,
                    GameUtil.SQUARE_LENGTH / 4 + 8,
                    GameUtil.SQUARE_LENGTH, GameUtil.SQUARE_LENGTH * 3 / 2
                    , this);
        }


        g2d.setComposite(composite_Opaque);
        for(int i = 0; i < 3; i++) {
            int num = GameUtil.leftMine / (int)Math.pow(10, 2 - i) % 10;

            g2d.drawImage(GameUtil.NumRedImage[num],
                    GameUtil.SQUARE_LENGTH / 4 + 8 + i * GameUtil.SQUARE_LENGTH + GameUtil.NumRedShift[num],
                    GameUtil.SQUARE_LENGTH / 4 + 8, GameUtil.SQUARE_LENGTH,
                    GameUtil.SQUARE_LENGTH * 3 / 2,
                    this);
        }
        for(int i = 0; i < 3; i++) {
            int num = GameTime.TimeInteger / (int)Math.pow(10, 2 - i) % 10;

            g2d.drawImage(GameUtil.NumRedImage[num],
                    width - GameUtil.SQUARE_LENGTH / 4 - 8  - GameUtil.SQUARE_LENGTH * 3 + i * GameUtil.SQUARE_LENGTH + GameUtil.NumRedShift[num],
                    GameUtil.SQUARE_LENGTH / 4 + 8, GameUtil.SQUARE_LENGTH,
                    GameUtil.SQUARE_LENGTH * 3 / 2,
                    this);
        }
    }
}
