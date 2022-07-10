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
        return new boolean[0][];
    }

    @Override
    public boolean isBlack() {
        return isBlack;
    }
}
