package mineSweeper;

public class BottomNum {

    public static void Crate(){



        for(int i = 1; i <= GameUtil.SquareHeightNum; i++) {
            for(int j = 1; j <= GameUtil.SquareWidthNum; j++) {
                if(GameUtil.DataBottom[i][j] == -1) {
                    for(int k = i - 1; k <= i + 1; k++) {
                        for(int l = j - 1; l <= j + 1; l++) {
                            if(GameUtil.DataBottom[k][l] >= 0) {
                                GameUtil.DataBottom[k][l]++;
                            }
                        }
                    }
                }
            }
        }



    }
}
