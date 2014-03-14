public class SpiralBug extends BoxBug {
    public  SpiralBug(int initSize) {
        super(initSize);
    }
    public void act() {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            sideLength++;
            steps = 0;
        }
    }
    
}