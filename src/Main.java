import codedraw.CodeDraw;
import codedraw.textformat.HorizontalAlign;
import codedraw.textformat.TextFormat;
import java.awt.event.KeyEvent;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static Figure[][] chessboard;
    public static boolean[][] movesArray;
    private static boolean hasWon;

    public static int round;
    private static boolean running = false; // ensures that only one mouse input is read at a time (among others).
    private static boolean moveAllow; // same function as above.
    private static boolean confirmed;
    public static File board = new File("./src/chessboard.png");
    public static int[] playerPosSelect = new int[2];

    public static Figure[] prisonPlayerB, prisonPlayerW;
    private static int eventLevel = 0;
    private static int[] inputPos = new int[2];
    private static int[] inputPosConf = new int[2];
    private static Figure figure = null;

    public static void main(String[] args) {
        File chess2 = new File("./src/chess_2.png");

        CodeDraw cd = new CodeDraw(1440, 1080);
        TextFormat format = cd.getTextFormat();
        format.setFontName("Bahnschrift");
        format.setHorizontalAlign(HorizontalAlign.CENTER);
        format.setFontSize(24);

        cd.setTitle("Chess 2 - Electric Boogaloo");
        cd.drawImage(440, 300, chess2);
        cd.show();
        cd.show(1000);
        for (int i = 0; i < 256; i++) {
            cd.clear();
            cd.drawImage(440, 300, chess2);
            Color var = new Color(255-i , 255-i, 255-i);
            cd.setColor(var);
            cd.drawText(720, 600, "Programmed by Karetoko :)");
            cd.show(2);
        }
        cd.show(500);
        format.setFontSize(36);
        cd.drawText(720, 880, "Press any keyboard button to continue");
        cd.show();

        // I have yet to figure out how to make the program only continue run when a keyboard input has been entered.
        // this shouldn't be that hard, but I can't figure this out... :(
        // Re: Nevermind, Lambdas are your friend here :)
        AtomicBoolean hasHappened = new AtomicBoolean(false);
        cd.onKeyDown((CodeDraw codeDraw, KeyEvent keyEvent) -> {
            hasHappened.set(true);
        });
        while (!hasHappened.get()) {
            cd.show(10);
        }

        System.out.println("SUCCESS");
        cd.clear();
        cd.show(2000);


        // game run
        while (true) {
            // sorry for the wall of text, I went the more "manual" way here...
            {
            hasWon = false;
            round = 1;
            prisonPlayerB = new Figure[2];
            prisonPlayerW = new Figure[2]; // position 0 is king, position 1 is queen (this is slightly different from the actual rules, but I chose to tweak this for simplicity's sake, sorry)
            cd.clear();
            cd.drawImage(170, 10, board);
            cd.show();
            chessboard = new Figure[8][8];
            chessboard[0][0] = new Raven(true);
            chessboard[0][7] = new Raven(true);
            chessboard[7][0] = new Raven(false);
            chessboard[7][7] = new Raven(false);
            chessboard[0][1] = new Monkey(true);
            chessboard[0][6] = new Monkey(true);
            chessboard[7][1] = new Monkey(false);
            chessboard[7][6] = new Monkey(false);
            chessboard[1][2] = new Elephant(true);
            chessboard[1][5] = new Elephant(true);
            chessboard[6][2] = new Elephant(false);
            chessboard[6][5] = new Elephant(false);
            chessboard[1][0] = new Fish(true);
            chessboard[1][1] = new Fish(true);
            chessboard[0][2] = new Fish(true);
            chessboard[1][3] = new Fish(true);
            chessboard[1][4] = new Fish(true);
            chessboard[0][5] = new Fish(true);
            chessboard[1][6] = new Fish(true);
            chessboard[1][7] = new Fish(true);
            chessboard[6][0] = new Fish(false);
            chessboard[6][1] = new Fish(false);
            chessboard[7][2] = new Fish(false);
            chessboard[6][3] = new Fish(false);
            chessboard[6][4] = new Fish(false);
            chessboard[7][5] = new Fish(false);
            chessboard[6][6] = new Fish(false);
            chessboard[6][7] = new Fish(false);
            chessboard[0][4] = new King(true);
            chessboard[7][4] = new King(false);
            chessboard[0][3] = new Queen(true);
            chessboard[7][3] = new Queen(false);
            Bear Bear = new Bear();
            int[] temp = new int[2];
            int timeout = 100;
            temp = fromBoardCoordinates(0,0);
            chessboard[0][0].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(1,0);
            chessboard[0][1].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(2,0);
            chessboard[0][2].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(3,0);
            chessboard[0][3].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(4,0);
            chessboard[0][4].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(5,0);
            chessboard[0][5].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(6,0);
            chessboard[0][6].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(7,0);
            chessboard[0][7].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(0,1);
            chessboard[1][0].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(1,1);
            chessboard[1][1].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(2,1);
            chessboard[1][2].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(3,1);
            chessboard[1][3].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(4,1);
            chessboard[1][4].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(5,1);
            chessboard[1][5].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(6,1);
            chessboard[1][6].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(7,1);
            chessboard[1][7].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);

            temp = fromBoardCoordinates(0,6);
            chessboard[6][0].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(1,6);
            chessboard[6][1].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(2,6);
            chessboard[6][2].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(3,6);
            chessboard[6][3].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(4,6);
            chessboard[6][4].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(5,6);
            chessboard[6][5].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(6,6);
            chessboard[6][6].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(7,6);
            chessboard[6][7].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(0,7);
            chessboard[7][0].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(1,7);
            chessboard[7][1].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(2,7);
            chessboard[7][2].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(3,7);
            chessboard[7][3].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(4,7);
            chessboard[7][4].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(5,7);
            chessboard[7][5].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(6,7);
            chessboard[7][6].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            temp = fromBoardCoordinates(7,7);
            chessboard[7][7].drawFigure(cd, temp[0], temp[1]);
            cd.show(timeout);
            Bear.drawFigure(cd,670, 440);
            cd.show(800);}

            format.setFontSize(48);
            // cd.drawText(720, 1000, "Round 1 - Player White begins!");
            cd.show();
            while (!hasWon) {
                cd.onMouseClick(Main::inputReader);
                /*
                cd.onMouseClick(Main::gameRun);
                hasWon = true;
                cd.show(10000);
                */
                cd.setColor(Color.WHITE);
                cd.fillRectangle(0,0,250, 350);
                cd.setColor(Color.BLACK);
                String textOutput = "";
                if (round % 2 == 0) {
                    textOutput += "Black";
                } else {
                    textOutput += "White";
                }
                cd.drawText(130, 220, textOutput);
                cd.drawText(130, 150, "" + round);
                cd.drawText(130, 100, "Round");
                cd.show();

                /*
                Small explanation to the eventLevels:
                    -
                */

                if (eventLevel == 1) {
                    figure = null;
                    cd.clear();
                    drawBoard(cd);
                    cd.show();
                    System.out.println("EVENT LEVEL = 1");
                    eventLevel = 4;
                    int[] boardPos; // positions on the board, not actual coordinates on window!
                    boardPos = toBoardCoordinates(inputPos[0], inputPos[1]);
                    if (chessboard[boardPos[1]][boardPos[0]] != null) {
                        figure = chessboard[boardPos[1]][boardPos[0]];
                        boolean roundColour = (round % 2 == 0);
                        if (figure.isBlack() == roundColour) {
                            int[] figurePos = fromBoardCoordinates(boardPos[0], boardPos[1]);
                            cd.drawImage(figurePos[0], figurePos[1], "./src/red.png");
                            movesArray = figure.availableMoves(chessboard, boardPos[0], boardPos[1]);
                            drawMoves(cd, movesArray);
                            cd.show();
                            eventLevel = 2;
                        } else {
                            cd.clear();
                            drawBoard(cd);
                            String temp = "It's ";
                            if (round % 2 == 1) {
                                temp += "white's ";
                            } else {
                                temp += "black's ";
                            }
                            temp += "turn to move!";
                            cd.drawText(720, 1000, temp);
                            cd.show();
                            eventLevel = 0;
                        }
                    } else {
                        eventLevel = 0;
                    }
                } else if (eventLevel == 3) {
                    System.out.println("EVENT LEVEL = 3");
                    int[] boardPosConf = toBoardCoordinates(inputPosConf[0],inputPosConf[1]);
                    if (movesArray[boardPosConf[0]][boardPosConf[1]]) {
                        eventLevel = 4;
                        int[] boardPos = toBoardCoordinates(inputPos[0], inputPos[1]);
                        figure.movementAnimation(cd, inputPos[0], inputPos[1], inputPosConf[0], inputPosConf[1]);
                        Figure tempSave = null;
                        if (chessboard[boardPosConf[1]][boardPosConf[0]] != null) {
                            tempSave = chessboard[boardPosConf[1]][boardPosConf[0]];
                        }
                        chessboard[boardPosConf[1]][boardPosConf[0]] = chessboard[boardPos[1]][boardPos[0]];
                        if ((boardPosConf[0] != boardPos[0]) || (boardPosConf[1] != boardPos[1])) {
                            chessboard[boardPos[1]][boardPos[0]] = null;
                            System.out.println("CALLED");
                        }
                        if (tempSave != null && (tempSave.getClass() == King.class || tempSave.getClass() == Queen.class)) {
                            if (tempSave.getClass() == King.class) {
                                if (tempSave.isBlack()) {
                                    prisonPlayerW[0] = tempSave;
                                } else {
                                    prisonPlayerB[0] = tempSave;
                                }
                            } else { // for Queen
                                if (tempSave.isBlack()) {
                                    prisonPlayerW[1] = tempSave;
                                } else {
                                    prisonPlayerB[1] = tempSave;
                                }
                            }
                        }

                        for (int i = 0; i < 8; i++) {
                            if (chessboard[0][i] != null && chessboard[0][i].getClass() == Fish.class && !chessboard[0][i].isBlack()) {
                                chessboard[0][i].changeMode();
                            }
                            if (chessboard[7][i] != null && chessboard[7][i].getClass() == Fish.class && chessboard[7][i].isBlack()) {
                                chessboard[7][i].changeMode();
                            }
                        }

                        if (chessboard[boardPosConf[1]][boardPosConf[0]] != null && chessboard[boardPosConf[1]][boardPosConf[0]].getClass() == Monkey.class && chessboard[boardPosConf[1]][boardPosConf[0]].customRequest()) {
                            chessboard[boardPosConf[1]][boardPosConf[0]].changeMode();
                            if (chessboard[4][0] == null) {
                                chessboard[4][0] = prisonPlayerW[0];
                                prisonPlayerW[0] = null;
                            }
                            chessboard[4][0].changeMode();
                        }

                        drawBoard(cd);
                        cd.show();


                        if ((chessboard[4][0] != null || chessboard[3][7] != null)) {
                            if (chessboard[4][0].getClass() == Monkey.class && prisonPlayerW[0].customRequest() && (round % 2 == 0) && boardPosConf[0] == 0 && boardPosConf[1] == 4) {
                                inputPos = fromBoardCoordinates(4, 0);
                                eventLevel = 5;
                                if (!(boardPos[0] == 0 && boardPos[1] == 4)) {
                                    round--;
                                }
                                chessboard[4][0].changeMode();
                                System.out.println("THROUGH MAIN");
                            }
                        }

                        round++;

                        if (prisonPlayerB[0] != null && prisonPlayerB[1] != null && prisonPlayerW[0] != null && prisonPlayerW[1] != null) {
                            if ((prisonPlayerB[0].getClass() == King.class && prisonPlayerB[1].getClass() == Queen.class) || (prisonPlayerW[0].getClass() == King.class && prisonPlayerW[1].getClass() == Queen.class)) {
                                hasWon = true; // game-ending condition
                            }
                        }

                        // eventLevel shall not be changed when a monkey is on retrieval mode!
                        if (!(chessboard[4][0] != null && chessboard[4][0].getClass() == Monkey.class && chessboard[4][0].customRequest())) {
                            eventLevel = 0;
                        }
                    } else {
                        cd.clear();
                        drawBoard(cd);
                        if (!(chessboard[4][0] != null && chessboard[4][0].getClass() == Monkey.class)) {
                            cd.drawText(720, 1000, "You cannot move there with this figure!");
                        }
                        cd.show();
                        if (!(chessboard[4][0] != null && chessboard[4][0].getClass() == Monkey.class)) {
                            eventLevel = 0;
                            System.out.println("CALLED AT 3");
                        } else {
                            eventLevel = 5;
                            // chessboard[4][0].changeMode();
                        }
                    }
                } else if (eventLevel == 5) {
                    inputPos = fromBoardCoordinates(0,4);
                    figure = null;
                    cd.clear();
                    drawBoard(cd);
                    cd.show();
                    System.out.println("EVENT LEVEL = 5");
                    eventLevel = 4;
                    int[] boardPos; // positions on the board, not actual coordinates on window!
                    boardPos = toBoardCoordinates(inputPos[0], inputPos[1]);
                    if (chessboard[boardPos[1]][boardPos[0]] != null) {
                        figure = chessboard[boardPos[1]][boardPos[0]];
                        boolean roundColour = (round % 2 == 0);
                        int[] figurePos = fromBoardCoordinates(boardPos[0], boardPos[1]);
                        cd.drawImage(figurePos[0], figurePos[1], "./src/red.png");
                        movesArray = figure.availableMoves(chessboard, boardPos[0], boardPos[1]);
                        drawMoves(cd, movesArray);
                        cd.show();
                        eventLevel = 2;
                        // chessboard[boardPos[1]][boardPos[0]].changeMode();
                    } else {
                        eventLevel = 5;
                        System.out.println("CALLED 5");
                    }
                }
                cd.show(5);

            }
        }
    }

    private static void inputReader(CodeDraw codeDraw, MouseEvent me) {
        if (eventLevel == 0) {
            inputPos[0] = me.getX();
            inputPos[1] = me.getY();
            int[] check = toBoardCoordinates(inputPos[0], inputPos[1]);
            if (check[0] >= 0 && check[0] <= 7 && check[1] >= 0 && check[1] <= 7 && inputPos[0] >= 327 && inputPos[1] >= 98) {
                eventLevel = 1;
            }
            // System.out.println("inputPos[0]: " + inputPos[0]);
            // System.out.println("inputPos[1]: " + inputPos[1]);
        } else if (eventLevel == 2) {
            inputPosConf[0] = me.getX();
            inputPosConf[1] = me.getY();
            int[] check = toBoardCoordinates(inputPosConf[0], inputPosConf[1]);
            if (check[0] >= 0 && check[0] <= 7 && check[1] >= 0 && check[1] <= 7 && inputPosConf[0] >= 327 && inputPosConf[1] >= 98) {
                eventLevel = 3;
            }
            // System.out.println("inputPosConf[0]: " + inputPosConf[0]);
            // System.out.println("inputPosConf[1]: " + inputPosConf[1]);
        }
    }


    public static void add(Figure figure, int x, int y) {

    }

    public static boolean isEmpty(int x, int y) {
        return false;
    }

    public static Figure remove(int x, int y) {
        return null;
    }

    public static void reposition(int startX, int startY, int endX, int endY) {

    }

    // input is board position (0-7), output is actual coordinates as format int[2]{x-coords, y-coords}.
    private static int[] fromBoardCoordinates(int x, int y) {
        int[] output = new int[2];
        output[0] = 328 + x * 97;
        output[1] = 100 + y * 97;
        return output;
    }

    // the reverse operation of boardCoordinates(); i.e. from actual coordinates to board position.
    private static int[] toBoardCoordinates(int x, int y) {
        int[] output = new int[2];
        output[0] = (int) (((x-328)/97));
        output[1] = (int) (((y-100)/97));
        return output;
    }

    private static void drawMoves(CodeDraw cd, boolean[][] ma) {
        for (int i = 0; i < ma.length; i++) {
            for (int j = 0; j < ma[i].length; j++) {
                if (ma[i][j]) {
                    int[] temp = fromBoardCoordinates(i, j);
                    cd.drawImage(temp[0], temp[1], "./src/blue.png");
                }
            }
        }
    }

    private static void confirmMove(CodeDraw cd, MouseEvent me) {
        while (moveAllow) {
            moveAllow = false;
            int[] clickConf = new int[2];
            clickConf[0] = me.getX(); // [0] = x-coordinate
            clickConf[1] = me.getY(); // [1] = y-coordinate
            int[] boardPosConf = toBoardCoordinates(clickConf[0],clickConf[1]);
            if (!movesArray[boardPosConf[0]][boardPosConf[1]]) {
                cd.clear();
                drawBoard(cd);
                cd.drawText(720, 1000, "You cannot move there with this figure!");
                cd.show();
                moveAllow = true;
                cd.onMouseClick(Main::confirmMove);
                moveAllow = false;
            } else {
                playerPosSelect = clickConf;
                confirmed = true;
            }
        }
    }

    public static void drawBoard(CodeDraw cd) {
        cd.drawImage(170, 10, board);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard[j][i] != null) {
                    int[] temp = fromBoardCoordinates(i, j);
                    chessboard[j][i].drawFigure(cd, temp[0], temp[1]);
                }
            }
        }
        if (prisonPlayerB[0] != null) {
            prisonPlayerB[0].drawFigure(cd, 1104+60 ,388);
        }
        if (prisonPlayerB[1] != null) {
            prisonPlayerB[1].drawFigure(cd, 1104+60 ,485);
        }
        if (prisonPlayerW[0] != null) {
            prisonPlayerW[0].drawFigure(cd, 231-60,485);
        }
        if (prisonPlayerW[1] != null) {
            prisonPlayerW[1].drawFigure(cd, 231-60 ,388);
        }
    }


    private static void gameRun(CodeDraw cd, MouseEvent me) {


        if (!running) {
            running = true; // ALWAYS first statement!
            Figure figure = null;
            int[] clickPos = new int[2];
            int[] boardPos;
            clickPos[0] = me.getX(); // [0] = x-coordinate
            clickPos[1] = me.getY(); // [1] = y-coordinate
            boardPos = toBoardCoordinates(clickPos[0], clickPos[1]);
            if (chessboard[boardPos[0]][boardPos[1]] != null) {
                figure = chessboard[boardPos[0]][boardPos[1]];
            }
            int[] figurePos = fromBoardCoordinates(boardPos[0], boardPos[1]);
            cd.drawImage(figurePos[0], figurePos[1], "./src/red.png");
            movesArray = figure.availableMoves(chessboard, boardPos[0], boardPos[1]);
            drawMoves(cd, movesArray);
            cd.show();
            System.out.println("PASSED - 1");
            /*
            AtomicBoolean hasHappened = new AtomicBoolean(false);
            cd.onKeyDown((CodeDraw codeDraw, KeyEvent keyEvent) -> {
                hasHappened.set(true);
            });
            while (!hasHappened.get()) {
                cd.show(10);
            }
            */
            if (running) {
                moveAllow = true;
                cd.onMouseClick(Main::confirmMove);
                moveAllow = false;
            }
            System.out.println("PASSED - 2");
            while (!confirmed) {
                cd.show(10);
            }

            int[] boardPosConf = toBoardCoordinates(playerPosSelect[0],playerPosSelect[1]);
            figure.movementAnimation(cd,boardPos[0],boardPos[1],boardPosConf[0],boardPosConf[1]);
            chessboard[boardPosConf[0]][boardPosConf[1]] = chessboard[boardPos[0]][boardPos[1]];
            chessboard[boardPos[0]][boardPos[1]] = null;
            drawBoard(cd);
            cd.show();
            running = false;
        }
    }
}
