public class Player {
    private Figure[] jail = new Figure[2]; // note: lower index facing player!
    private int[] dead = new int[6]; // 0 == fish (incl. king fish), 1 == raven, 2 == monkey, 3 == elephant, 4 == queen, 5 == king. Bear wil be noted in-game.
    private int round = 0;

    public Player() {}

}
