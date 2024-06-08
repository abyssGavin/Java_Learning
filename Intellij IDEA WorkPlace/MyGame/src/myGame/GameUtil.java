package myGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


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




    //雷
    static File fileMine = new File("src/images/Mine.png");
    static Image MineImage;
    //旗帜
    static File fileFlag = new File("src/images/flag.jpg");
    static Image FlagImage;
    //空白
    static File fileNoFlag = new File("src/images/noFlag.jpg");
    static Image NoFlagImage;
    //错误
    static File fileWrong = new File("src/images/wrong.png");
    static Image WrongImage;
    //笑脸给多了
    static File fileFace = new File("src/images/Face.png");
    static Image FaceImage;
    //数字
    static Image[] NumColorfulImage = new Image[10];
    static Image[] NumRedImage = new Image[10];


    static {
        try {
            MineImage = ImageIO.read(fileMine);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            FlagImage = ImageIO.read(fileFlag);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            NoFlagImage = ImageIO.read(fileNoFlag);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            WrongImage = ImageIO.read(fileWrong);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static {
            try {
                FaceImage = ImageIO.read(fileFace);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    static {
        for (int i = 1; i <= 8; i++) {
            File fileNum = new File("src/images/NumColorful/" + i + ".png");
            try {
                NumColorfulImage[i] = ImageIO.read(fileNum);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static {
        for (int i = 0; i <= 9; i++) {
            File fileNum = new File("src/images/NumRed/数字" + i + ".png");
            try {
                NumRedImage[i] = ImageIO.read(fileNum);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private GameUtil() {
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
        for(int i = 0; i < SquareHeightNum + 2; i++)
            for(int j = 0; j < SquareWidthNum + 2; j++) {
                DataBottom[i][j] = 0;
                DataTop[i][j] = 0;
                DataWrong[i][j] = false;
            }
        overCommand = false;
        GameTime = 0;
        myGame.GameTime.TimeInteger = 0;
        NumberOfGames++;

    }


}
