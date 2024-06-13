package mineSweeper;

import java.awt.*;

public class LayoutBottomMap extends LayoutAdapter {
    @Override
    public void addLayoutComponent(Component comp, Object constraints) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public void layoutContainer(Container parent) {

        int count = parent.getComponentCount();
        int i = 1;
        int j = 1;
        int k = 0;
        int MaxIndex = GameUtil.SquareWidthNum * GameUtil.SquareHeightNum;
        for (k = 0; k < GameUtil.SquareWidthNum * GameUtil.SquareHeightNum && k < count; k++) {

            Component comp = parent.getComponent(k);
            comp.setBounds(GameUtil.SQUARE_LENGTH * (j - 1) + GameUtil.OFFSET_LEFT,
                    GameUtil.SQUARE_LENGTH * (i - 1) + GameUtil.OFFSET_TOP,
                    GameUtil.SQUARE_LENGTH,
                    GameUtil.SQUARE_LENGTH);
            if(j < GameUtil.SquareWidthNum) j++;
            else{
                i++;
                j = 1;
            }
        }

        if(k < MaxIndex + 1 && k < count) {
            Component comp = parent.getComponent(k);
            comp.setBounds(GameUtil.OFFSET_LEFT - 8, GameUtil.OFFSET_TOP / 4 - 8, GameUtil.MapWidth - GameUtil.OFFSET_LEFT - GameUtil.OFFSET_RIGHT + 16, GameUtil.OFFSET_TOP / 2 + 16);
        }




    }




}
