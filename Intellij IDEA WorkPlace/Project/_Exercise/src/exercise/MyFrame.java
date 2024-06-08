package exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class MyFrame extends JFrame {
    public MyFrame(String Title) {
        super(Title);
        JPanel root = new JPanel();
        this.setContentPane(root);

        MyControl c = new MyControl();
        c.setPreferredSize(new Dimension(400, 400));
        root.add(c);

        c.setImage(new File("_Exercise/src/exercise/雷.png"));
        c.setPicture();


        c.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("**mousePress**");
                System.out.println(e.getPoint());
                System.out.println(e.getLocationOnScreen());
                System.out.println(e.getSource());
                System.out.println(e.getButton());
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }
}
