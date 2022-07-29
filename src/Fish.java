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
    Queen fishQueenTemplate;

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
        boolean[][] output = new boolean[8][8];
        if (this.isQueen) {
            output = fishQueenTemplate.availableMoves(board, x, y);
        } else {
            // for testing/monitoring purposes
            /*
            String temp = "";
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] == null) {
                        temp += " 0 ";
                    } else {
                        temp += " I ";
                    }
                }
                temp+= "\n";
            }
            System.out.println(temp);
            */
            if (this.isBlack) {
                // IMPORTANT: coordinates for board are reversed!!!!
                if (board[y + 1][x] == null && (y+1 < 8)) {
                    output[x][y + 1] = true;
                }
                if ((x + 1 < 8) && (y + 1 < 8) && board[y + 1][x + 1] != null) {
                    if (!board[y + 1][x + 1].isBlack()) {
                        output[x + 1][y + 1] = true;
                    }
                }
                if ((x - 1 >= 0) && (y + 1 < 8) && board[y + 1][x - 1] != null) {
                    if (!board[y + 1][x - 1].isBlack()) {
                        output[x - 1][y + 1] = true;
                    }
                }
            } else {
                if (board[y - 1][x] == null && (y-1 >= 0)) {
                    output[x][y - 1] = true;
                }
                if ((x + 1 < 8) && (y-1 >= 0) && board[y - 1][x + 1] != null) {
                    if (board[y - 1][x + 1].isBlack()) {
                        output[x + 1][y - 1] = true;
                    }
                }
                if ((x - 1 >= 0) && (y-1 >= 0) && board[y - 1][x - 1] != null) {
                    if (board[y - 1][x - 1].isBlack()) {
                        output[x - 1][y - 1] = true;
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
    // puropse of changeMode here: change fish to fishQueen (permanent for given object!)
    public void changeMode() {
        if (this.isBlack) {
            this.main = fishQueenB;
        } else {
            this.main = fishQueenW;
        }
        this.isQueen = true;
        fishQueenTemplate = new Queen(this.isBlack);
    }

}
