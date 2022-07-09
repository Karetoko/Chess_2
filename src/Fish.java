import codedraw.CodeDraw;

import java.io.File;

public class Fish implements Figure{
    public boolean isBlack;
    private boolean isQueen;
    private File main;
    File fishB = new File("./src/fish_b.png");
    File fishW = new File("./src/fish_w.png");
    File fishQueenB = new File("./src/fish_king_b.png");
    File fishQueenW = new File("./src/fish_king_w.png");

    public Fish(boolean isBlack) {
        this.isBlack = isBlack;
        this.isQueen = false;
        if (isBlack) {
            this.main = fishB;
        } else {
            this.main = fishW;
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

}
