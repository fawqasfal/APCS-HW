import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public class DancingBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        int[] jacksonsMoves = {0,0,0,0,3,0,0,0,0,5,0,0,0,0};
        DancingBug michaelJackson = new DancingBug(jacksonsMoves);
        world.add(new Location(4,4), michaelJackson);
        world.show();
    }
}