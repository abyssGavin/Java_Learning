package exercise;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new MyFrame("test");
        frame.setBounds(200, 200, 800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
