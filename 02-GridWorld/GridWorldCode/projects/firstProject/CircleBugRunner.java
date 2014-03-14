import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public class CircleBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        CircleBug rolyPoly = new CircleBug(5);
        world.add(new Location(4,4), rolyPoly);
        world.show();
    }
}