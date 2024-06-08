package exercise;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyControl extends JPanel {

    File file = null;

    int pictureWidth;
    int pictureHeight;
    BufferedImage image;




    public void setImage(File file){
        this.file = file;
    }


    public void setPicture() {
        try {
            this.image = ImageIO.read(this.file);

            pictureHeight = image.getHeight();
            pictureWidth = image.getWidth();
            System.out.println('1');

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);


        if (file != null) {



            double race1 = (double) width / height;


            double race2 = (double) pictureWidth / pictureHeight;


            if (race1 >= race2) {
                g.drawImage(image, (int) ((double) width / 2 - height * race2 / 2), 0, (int) (height * race2), height, null);
            } else {

                g.drawImage(image, 0, (int) ((double) height / 2 - width / race2 / 2), width, (int) (width / race2), null);
            }


        }


    }


}