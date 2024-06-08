package myGame;

public class MineCreate {

    static boolean nonMine;
    static int x, y;
    static void Create(int nonMineX, int nonMineY) {


        for (int i = 0; i < GameUtil.MineNum && i < GameUtil.SquareWidthNum * GameUtil.SquareHeightNum; ) {
            nonMine = true;
            x = (int) (Math.random() * 1000 % GameUtil.SquareWidthNum + 1);
            y = (int) (Math.random() * 1000 % GameUtil.SquareHeightNum + 1);
            for(int j = -1; j < 2; j++)
                for(int k = -1; k < 2; k++)
                    if (nonMineX + k == x && nonMineY + j == y ) {
                        nonMine = false;
                        break;
                    }
            if (GameUtil.DataBottom[y][x] == 0 && nonMine) {
                GameUtil.DataBottom[y][x] = -1;
                i++;

            }
        }
    }



}
