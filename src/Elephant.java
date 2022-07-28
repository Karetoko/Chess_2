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
