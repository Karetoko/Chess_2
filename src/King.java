import codedraw.CodeDraw;

import java.io.File;

public class King implements Figure{
    public boolean isBlack;
    public boolean hasBanana;
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
        boolean[][] output = new boolean[8][8];
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (!(i == 0 && j == 0)) {
                    if ((x + i < 8) && (x + i >= 0) && (y + j < 8) && (y + j >= 0) && (board[y + j][x + i] == null || board[y + j][x + i].isBlack() != this.isBlack)) {
                        output[x + i][y + j] = true;
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
        hasBanana = false;
    }

    @Override
    public boolean customRequest() {
        // returns if King has banana
        return hasBanana;
    }
}
