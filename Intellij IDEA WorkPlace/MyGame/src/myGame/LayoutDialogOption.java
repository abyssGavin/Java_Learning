package myGame;

import java.awt.*;

public class LayoutDialogOption extends LayoutAdapter{
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
                    comp.setBounds((parent.getWidth() - compSize.width) / 2, 50 * (3 * i - 2), compSize.width, compSize.height);
                case 2:
                    comp.setBounds((parent.getWidth() - compSize.width) / 2, 50 * (3 * i - 2), compSize.width, compSize.height);
                case 3:
                    comp.setBounds((parent.getWidth() - compSize.width) / 2, 50 * (3 * i - 2), compSize.width, compSize.height);
                case 4:
                    comp.setBounds((parent.getWidth() - compSize.width) / 2, 50 * (3 * i - 2), compSize.width, compSize.height);

            }
        }
    }
}
