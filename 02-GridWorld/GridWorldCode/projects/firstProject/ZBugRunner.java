import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public class ZBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        ZBug rolyPoly = new ZBug(5);
        world.add(new Location(4,4), rolyPoly);
        world.show();
    }
}