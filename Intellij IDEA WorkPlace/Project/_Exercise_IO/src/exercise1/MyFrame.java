package exercise1;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;

public class MyFrame extends JFrame {
    public MyFrame(String Title) throws IOException {
        super(Title);
        JPanel root = new JPanel();
        this.setContentPane(root);

        MyControl c = new MyControl();
        c.setPreferredSize(new Dimension(400,400));
        root.add(c);

        InputStream res = this.getClass().getResourceAsStream("/exercise1/雷.png");
        Image image = null;
        if (res != null) {
            image = ImageIO.read(res);
        }
        if (image != null) {
            c.setPicture(image);
        }

        Border border1 = BorderFactory.createLineBorder(Color.BLUE, 4);
        Border border2 = new LineBorder(Color.BLUE, 4);
        c.setBorder(border1);









        JButton button = new JButton();
        button.setBounds(200,200,40,20);
        c.add(button);

        JButton button2 = new JButton();
        button2.setBounds(400,400,100,50);
        c.add(button2);

        JButton button3 = new JButton();
        button3.setBounds(600,600,100,50);
        c.add(button3);

        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(new JOptionPane(), "点击了");
            }
        };

        MouseListener mouseListener2 = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int select = JOptionPane.showConfirmDialog(new JOptionPane(), "是否确认", "queren", JOptionPane.YES_NO_CANCEL_OPTION);
                if (select == 0){
                    JOptionPane.showMessageDialog(new JOptionPane(), "yes");
                }
            }
        };

        MouseListener mouseListener3 = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String input = JOptionPane.showInputDialog(new JOptionPane(), "please input 0000", 0000);
                if(input != null) {
                    JOptionPane.showMessageDialog(new JOptionPane(), input);
                }
            }
        };

        button.addMouseListener(mouseListener);
        button2.addMouseListener(mouseListener2);
        button3.addMouseListener(mouseListener3);












    }
}
