import codedraw.CodeDraw;

import java.io.File;

public class Bear implements Figure{
    File bear = new File("./src/bear.png");

    public Bear() {}

    @Override
    public void drawFigure(CodeDraw cd, int x, int y) {
        cd.drawImage(x,y,bear);
    }

    @Override
    public void movementAnimation(CodeDraw cd, int startX, int startY, int endX, int endY) {

    }

    @Override
    public boolean[][] availableMoves(Figure[][] board, int x, int y) {
        boolean[][] output = new boolean[8][8];
        if (board[3][3] == null) {
            output[3][3] = true;
        }
        if (board[3][4] == null) {
            output[4][3] = true;
        }
        if (board[4][3] == null) {
            output[3][4] = true;
        }
        if (board[4][4] == null) {
            output[4][4] = true;
        }
        return output;
    }

    @Override
    public boolean isBlack() {
        return false; // Bear doesn't have any colour coding.
    }

    @Override
    public void changeMode() {

    }

    @Override
    public boolean customRequest() {
        return false;
    }
}
