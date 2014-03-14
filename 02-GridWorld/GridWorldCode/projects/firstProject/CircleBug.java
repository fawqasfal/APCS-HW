/*
" * This code is distributed in the hope that it will be useful,"
- Cay S. Horstmann on BoxBug.java
*/


public class CircleBug extends BoxBug {
    public CircleBug(int size) {
        super(size);
    }
    public void act() {
        if (steps < sideLength && canMove()) {
            move();
            steps++;
        }
        else {
            turn();
            this.steps = 0;
        }
    }
}