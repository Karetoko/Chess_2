import codedraw.CodeDraw;

import java.io.File;

public class Elephant implements Figure{
    public boolean isBlack;
    private File main;
    File elephantB = new File("./src/elephant_b.png");
    File elephantW = new File("./src/elephant_w.png");

    public Elephant(boolean isBlack) {
        this.isBlack = isBlack;
        if (isBlack) {
            this.main = elephantB;
        } else {
            this.main = elephantW;
        }
    }


    @Override
    public void drawFigure(CodeDraw cd, int x, int y) {
        cd.drawImage(x,y,main);
    }

    @Override
    public void movementAnimation(CodeDraw cd, int startX, int startY, int endX, int endY) {

    }

    @Override
    public boolean[][] availableMoves(Figure[][] board, int x, int y) {
        boolean[][] output = new boolean[8][8];
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (!(i == 0 || j == 0)) {
                    int stepCount = 0;
                    int tempX = x;
                    int tempY = y;
                    boolean figureReached = false;
                    while ((tempX + i < 8) && (tempX + i >= 0) && (tempY + j < 8) && (tempY + j >= 0) && !figureReached) {
                        tempX += i;
                        tempY += j;
                        if (board[tempY][tempX] == null) {
                            if (stepCount % 2 == 1) {
                                output[tempX][tempY] = true;
                            }
                        } else if (board[tempY][tempX].isBlack() != this.isBlack) {
                            if (stepCount % 2 == 1) {
                                output[tempX][tempY] = true;
                                figureReached = true;
                            } else {
                                figureReached = true;
                            }
                        } else {
                            figureReached = true;
                        }
                        stepCount++;
                    }
                }
            }
        }
        return output;
    }

    @Override
    public boolean isBlack() {
        return isBlack;
    }

    @Override
    public void changeMode() {

    }

    @Override
    public boolean customRequest() {
        return false;
    }
}
