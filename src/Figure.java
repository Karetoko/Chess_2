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

    // mainly used for changing settings on any figure; usages can vary wildly (read below)!
    /*
    ---USAGES---
    Fish: changes fish to fishQueen (permanent for given object!)
    Raven: Changes option for if Raven is allowed to kill any opponents in a given round (toggle to allow/disallow)
    Bear: planned -> changes state from starting point to being moved (permanent!)
    Elephant: -none-
    Monkey: planned -> activates/deactivates "king retrieval" mode (main usage: different output in "availableMoves" method; toggle).
    Queen: -none-
    King: planned -> removes banana from king when rescued by monkey (permanent!)
    */
    void changeMode();

    boolean customRequest();
}
