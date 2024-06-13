package mineSweeper;

public class RandomMineCreationStrategy implements MineCreationStrategy {
    @Override
    public void createMines(int nonMineX, int nonMineY) {
        for (int i = 0; i < GameUtil.MineNum && i < GameUtil.SquareWidthNum * GameUtil.SquareHeightNum; ) {
            int x = (int) (Math.random() * GameUtil.SquareWidthNum + 1);
            int y = (int) (Math.random() * GameUtil.SquareHeightNum + 1);
            if (Math.abs(nonMineX - x) <= 0 && Math.abs(nonMineY - y) <= 0 ) continue;
            if (GameUtil.DataBottom[y][x] == 0) {
                GameUtil.DataBottom[y][x] = -1;
                i++;
            }
        }
    }
}
