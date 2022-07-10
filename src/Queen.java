import codedraw.CodeDraw;

import java.io.File;

public class Queen implements Figure{
    public boolean isBlack;
    private File main;
    File queenB = new File("./src/queen_b.png");
    File queenW = new File("./src/queen_w.png");

    public Queen(boolean isBlack) {
        this.isBlack = isBlack;
        if (isBlack) {
            this.main = queenB;
        } else {
            this.main = queenW;
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
        return new boolean[0][];
    }

    @Override
    public boolean isBlack() {
        return isBlack;
    }
}
