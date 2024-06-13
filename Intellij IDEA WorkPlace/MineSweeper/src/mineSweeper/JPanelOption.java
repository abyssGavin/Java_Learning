package mineSweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPanelOption extends JPanel {
    static JPanelOption jPanelOption;

    static void setJPanelOption(){
        jPanelOption = new JPanelOption();
    }




    private JPanelOption(){

        this.setPreferredSize(new Dimension(GameUtil.SQUARE_LENGTH * 3 / 2, GameUtil.SQUARE_LENGTH * 3 / 2));
        JPanelFunction.jPanelFunction.add(this);
        this.setVisible(true);
        this.revalidate();
        this.repaint();



        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1&&
                        e.getX() > 0 &&
                        e.getX() < GameUtil.SQUARE_LENGTH * 3 / 2 &&
                        e.getY() > 0 &&
                        e.getY() <GameUtil.SQUARE_LENGTH * 3 / 2 ){

                    JDialogOption.setJDialogOption(GameFrame.Game);



                }
            }
        });
    }





    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();


        g.setColor(new Color(192, 192, 192));
        g.fillRect(0, 0, width, height);

        g.drawImage(GameUtil.FaceImage, 0, 0, width, height, null);
    }



}
