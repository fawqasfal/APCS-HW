import info.gridworld.actor.Bug;

public class DancingBug extends Bug {
    int[] danceMoves;
    int thisMove = 0;
    public DancingBug(int[] showMeYaMoves) {
        this.danceMoves = showMeYaMoves;
    }
    public void act() {
        for (int i = 0; i < danceMoves[thisMove]; i++)
            turn();
        super.act();
        thisMove++;
        thisMove = thisMove % danceMoves.length;
    }
}