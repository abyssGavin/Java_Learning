package myGame;

import java.awt.*;

public class LayoutGameDegree extends LayoutAdapter{
    @Override
    public void addLayoutComponent(Component comp, Object constraints) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public void layoutContainer(Container parent) {
        int i = 0;
        for(Component comp : parent.getComponents()) {
            i++;
            Dimension compSize = comp.getPreferredSize();
            switch (i){
                case 1:
                    comp.setBounds((parent.getWidth() - compSize.width) / 5, 50 * (3 * i - 2), compSize.width, compSize.height);
                    break;
                case 2:
                    comp.setBounds((parent.getWidth() - compSize.width) / 5, 50 * (3 * i - 2), compSize.width, compSize.height);
                    break;
                case 3:
                    comp.setBounds((parent.getWidth() - compSize.width) / 5, 50 * (3 * i - 2), compSize.width, compSize.height);
                    break;
                case 4:
                    comp.setBounds((parent.getWidth() * 4 - compSize.width * 3) / 5, 50 * (2 * i - 7), compSize.width, compSize.height);
                    break;
                case 5:
                    comp.setBounds(parent.getWidth() / 2 + 30, 60 * (i - 2), compSize.width, compSize.height);
                    break;
                case 6:
                    comp.setBounds(parent.getWidth() / 2 + 30, 60 * (i - 2), compSize.width, compSize.height);
                    break;
                case 7:
                    comp.setBounds(parent.getWidth() / 2 + 20, 60 * (i - 2), compSize.width, compSize.height);
                    break;
                case 8:
                    comp.setBounds(parent.getWidth() / 2 + 200, 60 * (i - 5), compSize.width, compSize.height);
                    break;
                case 9:
                    comp.setBounds(parent.getWidth() / 2 + 200, 60 * (i - 5), compSize.width, compSize.height);
                    break;
                case 10:
                    comp.setBounds(parent.getWidth() / 2 + 200, 60 * (i - 5), compSize.width, compSize.height);
                    break;
                case 11:
                    comp.setBounds(parent.getWidth() / 2 + 50, 50 * 7 + 15, compSize.width - 30, compSize.height - 30);
                    break;
                case 12:
                    comp.setBounds(parent.getWidth() / 2  - 70, 50 * 9 + 15, compSize.width - 30, compSize.height - 30);
                    break;
            }
        }
    }
}
