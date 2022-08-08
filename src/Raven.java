import codedraw.CodeDraw;

import java.io.File;

public class Raven implements Figure{
    public boolean isBlack;
    private File main;
    private boolean enableKill = false;
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
                if (board[j][i] == null) {
                    output[i][j] = true;
                }
            }
        }
        if (enableKill) {
            if ((x + 1 < 8) && (x + 1 >= 0) && (y < 8) && (y >= 0) && (board[y][x + 1] == null || board[y][x + 1].isBlack() != this.isBlack)) {
                output[x + 1][y] = true;
            }
            if ((x < 8) && (x >= 0) && (y + 1 < 8) && (y + 1 >= 0) && (board[y + 1][x] == null || board[y + 1][x].isBlack() != this.isBlack)) {
                output[x][y + 1] = true;
            }
            if ((x - 1 < 8) && (x - 1 >= 0) && (y < 8) && (y >= 0) && (board[y][x - 1] == null || board[y][x - 1].isBlack() != this.isBlack)) {
                output[x - 1][y] = true;
            }
            if ((x < 8) && (x >= 0) && (y - 1 < 8) && (y - 1 >= 0) && (board[y - 1][x] == null || board[y - 1][x].isBlack() != this.isBlack)) {
                output[x][y - 1] = true;
            }
        }
        output[x][y] = false;
        return output;
    }

    @Override
    public boolean isBlack() {
        return isBlack;
    }

    @Override
    public void changeMode() {
        enableKill = !enableKill;
    }

    @Override
    public boolean customRequest() {
        return enableKill;
    }
}
