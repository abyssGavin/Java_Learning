package mineSweeper;

public class OptimizedMineCreationStrategy implements MineCreationStrategy {
    @Override
    public void createMines(int nonMineX, int nonMineY) {
        for (int j = 0; j < GameUtil.SquareHeightNum; j++) {
            for (int k = 0; k < GameUtil.SquareWidthNum; k++) {
                GameUtil.MineWeight[j + 1][k + 1] = 200 - 2 * (int)(
                        Math.abs(j - (GameUtil.SquareHeightNum + 1) / 2.0) +
                                Math.abs(k - (GameUtil.SquareWidthNum + 1) / 2.0)
                );
            }
        }

        for (int i = 0; i < GameUtil.MineNum && i < GameUtil.SquareWidthNum * GameUtil.SquareHeightNum; ) {
            boolean next = false;
            int mineTotalWeight = 0;

            for (int j = 0; j < GameUtil.SquareHeightNum; j++) {
                for (int k = 0; k < GameUtil.SquareWidthNum; k++) {
                    mineTotalWeight += GameUtil.MineWeight[j + 1][k + 1];
                }
            }

            int mineOptimizationPosition = (int)(Math.random() * mineTotalWeight);

            for (int j = 0; j < GameUtil.SquareHeightNum && !next; j++) {
                for (int k = 0; k < GameUtil.SquareWidthNum && !next; k++) {
                    mineOptimizationPosition -= GameUtil.MineWeight[j + 1][k + 1];
                    if (mineOptimizationPosition <= 0) {
                        if (GameUtil.DataBottom[j + 1][k + 1] == -1 ||
                                (Math.abs(nonMineY - j - 1) <= 1 && Math.abs(nonMineX - k - 1) <= 1)) {
                            next = true;
                            break;
                        }
                        GameUtil.DataBottom[j + 1][k + 1] = -1;
                        for (int l = -1; l < 2; l++) {
                            for (int m = -1; m < 2; m++) {
                                if (GameUtil.DataBottom[j + l + 1][k + m + 1] != -1)
                                    GameUtil.MineWeight[j + l + 1][k + m + 1] -= 10;
                            }
                        }
                        GameUtil.MineWeight[j + 1][k + 1] = 0;
                        next = true;
                        i++;
                    }
                }
            }
        }
    }
}