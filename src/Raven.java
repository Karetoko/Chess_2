import codedraw.CodeDraw;

import java.io.File;

public class Raven implements Figure{
    public boolean isBlack;
    private File main;
    File ravenB = new File("./src/raven_b.png");
    File ravenW = new File("./src/raven_w.png");

    public Raven(boolean isBlack) {
        this.isBlack = isBlack;
        if (isBlack) {
            this.main = ravenB;
        } else {
            this.main = ravenW;
        }
    }

    @Override
    public void drawFigure(CodeDraw cd, int x, int y) {
        cd.drawImage(x,y, 100, 100, main);
    }

    @Override
    public void movementAnimation(CodeDraw cd, int startX, int startY, int endX, int endY) {

    }

    @Override
    public boolean[][] availableMoves(Figure[][] board, int x, int y) {
        boolean[][] output = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                output[i][j] = true;
            }
        }
        return output;
    }
}
