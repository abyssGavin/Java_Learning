package mineSweeper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class GameUtil {

    static final int SQUARE_LENGTH = 40;
    static final int OFFSET_TOP = 160;
    static final int OFFSET_BOTTOM = 30;
    static final int OFFSET_LEFT = 30;
    static final int OFFSET_RIGHT = 30;
    static final int[] NumRedShift = {0, 8, 0, 0, 0, 0, 0, 3, 0, 0};
    static int SquareWidthNum;
    static int SquareHeightNum;
    static int MapWidth;
    static int MapHeight;
    static int FrameWidth;
    static int FrameHeight;
    static int MineNum;
    static int leftMine;
    static int NonMineNum;
    static int[][] DataBottom;
    static int[][] DataTop;
    static boolean[][] DataWrong;
    static boolean overCommand;
    static int GameTime;
    static long TimeBegin;
    static long TimeNow;
    static int NumberOfGames = 0;
    static Font font = new Font("楷体", Font.BOLD, 24);
    static Font fontButton = new Font("楷体", Font.BOLD, 40);
    static boolean MineOptimization; //布局优化
    static int[][] MineWeight; //雷数权重

    // 图片资源
    static Image MineImage;
    static Image FlagImage;
    static Image NoFlagImage;
    static Image WrongImage;
    static Image FaceImage;
    static Image[] NumColorfulImage = new Image[10];
    static Image[] NumRedImage = new Image[10];

    static {
        try {
            MineImage = loadImage("images/Mine.png");
            FlagImage = loadImage("images/flag.jpg");
            NoFlagImage = loadImage("images/noFlag.jpg");
            WrongImage = loadImage("images/wrong.png");
            FaceImage = loadImage("images/Face.png");

            for (int i = 1; i <= 8; i++) {
                NumColorfulImage[i] = loadImage("images/NumColorful/" + i + ".png");
            }

            for (int i = 0; i <= 9; i++) {
                NumRedImage[i] = loadImage("images/NumRed/数字" + i + ".png");
            }
            System.out.println("Images loaded successfully.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private GameUtil() {
    }

    private static Image loadImage(String path) throws IOException {
        InputStream inputStream = GameUtil.class.getClassLoader().getResourceAsStream(path);
        if (inputStream == null) {
            throw new IOException("Resource not found: " + path);
        }
        return ImageIO.read(inputStream);
    }

    public static void SetUtil(int widthSquareNum, int heightSquareNum, int mineNum) {
        SquareWidthNum = widthSquareNum;
        SquareHeightNum = heightSquareNum;
        MapWidth = SquareWidthNum * SQUARE_LENGTH + OFFSET_LEFT + OFFSET_RIGHT;
        MapHeight = SquareHeightNum * SQUARE_LENGTH + OFFSET_TOP + OFFSET_BOTTOM;
        FrameWidth = MapWidth + 16;
        FrameHeight = MapHeight + 39;
        MineNum = mineNum;
        leftMine = MineNum;
        NonMineNum = SquareWidthNum * SquareHeightNum - MineNum;
        DataBottom = new int[SquareHeightNum + 2][SquareWidthNum + 2];
        DataTop = new int[SquareHeightNum + 2][SquareWidthNum + 2];
        DataWrong = new boolean[SquareHeightNum + 2][SquareWidthNum + 2];
        for (int i = 0; i < SquareHeightNum + 2; i++)
            for (int j = 0; j < SquareWidthNum + 2; j++) {
                DataBottom[i][j] = 0;
                DataTop[i][j] = 0;
                DataWrong[i][j] = false;
            }
        overCommand = false;
        GameTime = 0;
        mineSweeper.GameTime.TimeInteger = 0;
        NumberOfGames++;
        MineWeight = new int[SquareHeightNum + 2][SquareWidthNum + 2];
    }

}