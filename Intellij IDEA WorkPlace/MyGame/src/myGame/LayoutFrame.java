package myGame;

import java.awt.*;

public class LayoutFrame extends LayoutAdapter {



    @Override
    public void addLayoutComponent(Component comp, Object constraints) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public void layoutContainer(Container parent) {
        for (Component comp : parent.getComponents()) {
            Dimension compSize = comp.getPreferredSize();
            int x = (parent.getWidth() - compSize.width) / 2;
            int y = (parent.getHeight() - compSize.height) / 2;
            // 设置组件的位置和大小，使其水平和垂直居中
            comp.setBounds(x, y, compSize.width, compSize.height);
        }

    }
}
