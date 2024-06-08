package exercise1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Point;
import java.util.List;


public class MyControl extends JPanel {

    File file = null;

    int pictureWidth;
    int pictureHeight;
    Image image;

    private boolean pressed = false;
    private List<Point> point = new ArrayList<>();


    public MyControl(){
        MyMouseListener l = new MyMouseListener();
        this.addMouseListener(l);
        this.addMouseMotionListener(l);

    }

    public void setPicture(Image image) {

        this.image = image;


        pictureHeight = image.getHeight(null);
        pictureWidth = image.getWidth(null);
        System.out.println('1');

    }


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        System.out.println('3');

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);

        System.out.println('3');

        if (image != null) {


            double race1 = (double) width / height;
            double race2 = (double) pictureWidth / pictureHeight;

            System.out.println('3');

            if (race1 >= race2) {
                g.drawImage(image, (int) ((double) width / 2 - height * race2 / 2), 0, (int) (height * race2), height, null);
            } else {

                g.drawImage(image, 0, (int) ((double) height / 2 - width / race2 / 2), width, (int) (width / race2), null);
            }


        }


        if(point.size() >= 2) {
            Point p1 = point.getFirst();
            g.setColor(Color.RED);
            for(int i = 0; i < point.size(); i++){
                Point p2 = point.get(i);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                p1 = p2;
            }
        }





    }



    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            point.clear();
            pressed = true;
            point.add(e.getPoint());//记录鼠标的位置

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            pressed = false;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(pressed) {
                point.add(e.getPoint());
            }

            repaint();
        }
    }







}