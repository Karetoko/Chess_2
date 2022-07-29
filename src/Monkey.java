import codedraw.CodeDraw;

import java.io.File;

public class Monkey implements Figure{
    public boolean isBlack;
    private boolean tookBanana;
    private File main;
    File monkeyB = new File("./src/monkey_b.png");
    File monkeyW = new File("./src/monkey_w.png");

    public Monkey(boolean isBlack) {
        this.isBlack = isBlack;
        this.tookBanana = false;
        if (isBlack) {
            this.main = monkeyB;
        } else {
            this.main = monkeyW;
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
                if (!(i == 0 && j == 0)) {
                    int stepCount = 0;
                    int tempX = x;
                    int tempY = y;
                    if ((tempX + i < 8) && (tempX + i >= 0) && (tempY + j < 8) && (tempY + j >= 0) && board[tempY + j][tempX + i] == null) {
                        output[tempX + i][tempY + j] = true;
                    }
                    boolean figureReached = false;
                    while ((tempX + i < 8) && (tempX + i >= 0) && (tempY + j < 8) && (tempY + j >= 0) && !figureReached) {
                        tempX += i;
                        tempY += j;
                        if (stepCount % 2 == 0) {
                            if (board[tempY][tempX] == null) {
                                figureReached = true;
                            } else {
                                if ((tempX + i < 8) && (tempX + i >= 0) && (tempY + j < 8) && (tempY + j >= 0)) {
                                    if (board[tempY + j][tempX + i] == null || board[tempY + j][tempX + i].isBlack() != this.isBlack) {
                                        output[tempX + i][tempY + j] = true;
                                    } else {
                                        figureReached = true;
                                    }
                                }
                            }
                        } else {
                            if (board[tempY][tempX] == null) {
                                if ((tempX + i < 8) && (tempX + i >= 0) && (tempY + j < 8) && (tempY + j >= 0)) {
                                    // nothing
                                } else {
                                    figureReached = true;
                                }
                            } else {
                                figureReached = true;
                            }
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
    public void changeToQueen() {

    }
}
