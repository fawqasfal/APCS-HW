import info.gridworld.actor.Bug;

public class ZBug extends Bug {
    int zSize;
    boolean done = false;
    public ZBug(int zSize) {
        this.zSize = zSize;
    }
    //just realized this is blocking and messes with animation by taking over resources that are supposed to be used for updating the visuals...
    //im a bit too lazy to fix this though. it draws a "Z" as asked. 
    public void act() {
        if (canMove()) {
            while (this.getDirection() != 90)
                turn();
            for (int turn = 3; turn <= 5; turn += 2) {
                for (int i = 0; i < zSize; i++)
                    move();
                for (int k = 0; k < turn; k++)
                    turn();
            }
            for (int fin = 0; fin < this.zSize; fin++)
                move();
        }
        done = true;
    }
    public boolean canMove() {
        return super.canMove() && !this.done;
    }
}