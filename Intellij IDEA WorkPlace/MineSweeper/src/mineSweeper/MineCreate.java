package mineSweeper;

public class MineCreate {
    private static MineCreationStrategy strategy;

    public static void createMines(int nonMineX, int nonMineY) {
        if(GameUtil.MineOptimization) strategy = new OptimizedMineCreationStrategy();
        else strategy = new RandomMineCreationStrategy();
        strategy.createMines(nonMineX, nonMineY);
    }
}