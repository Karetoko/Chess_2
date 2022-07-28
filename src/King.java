import codedraw.CodeDraw;

import java.io.File;

public class King implements Figure{
    public boolean isBlack;
    private boolean hasBanana;
    private File main;
    File kingB = new File("./src/king_b.png");
    File kingW = new File("./src/king_w.png");
    File banana = new File("./src/banana.png");

    public King (boolean isBlack) {
        this.isBlack = isBlack;
        this.hasBanana = true;
        if (isBlack) {
            this.main = kingB;
        } else {
            this.main = kingW;
        }
    }

    @Override
    public void drawFigure(CodeDraw cd, int x, int y) {
        cd.drawImage(x,y,main);
        if (hasBanana) cd.drawImage(x,y+4,banana);
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

    @Override
    public void changeToQueen() {

    }
}
