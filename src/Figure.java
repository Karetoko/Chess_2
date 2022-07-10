import codedraw.CodeDraw;

public interface Figure {
    // draws figure on canvas.
    void drawFigure(CodeDraw cd, int x, int y);

    // does the movement animation. Note: positional inputs are chessboard positions (in array), not actual coordinates!
    void movementAnimation(CodeDraw cd, int startX, int startY, int endX, int endY);

    // Returns the possible moveable areas for this figure.
    boolean[][] availableMoves(Figure[][] board, int x, int y);

    // "getter" regarding if a figure is black or white.
    boolean isBlack();
}
