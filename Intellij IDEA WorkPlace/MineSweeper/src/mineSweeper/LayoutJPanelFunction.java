package mineSweeper;

import java.awt.*;

public class LayoutJPanelFunction extends LayoutAdapter{
    @Override
    public void addLayoutComponent(Component comp, Object constraints) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public void layoutContainer(Container parent) {
        int index = 0;
        int count = parent.getComponentCount();
        Component comp;

        if(index < count) {
            comp = parent.getComponent(index++);
            Dimension compSize = comp.getPreferredSize();
            comp.setBounds((parent.getWidth() - compSize.width) / 2, (parent.getHeight() - compSize.height) / 2, compSize.width, compSize.height);
        }
    }
}
