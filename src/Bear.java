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
        return new boolean[0][];
    }

    @Override
    public boolean isBlack() {
        return false; // Bear doesn't have any colour coding.
    }

    @Override
    public void changeMode() {

    }
}
