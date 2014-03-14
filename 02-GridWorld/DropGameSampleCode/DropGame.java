import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class DropGame
{
   private Grid<Piece> theGrid;

   // Precondition: 0 <= column < theGrid.getNumCols()
   // @return null if no empty locations in column;
   // otherwise, the empty location with the
   // largest row index within the specified column;

   public Location dropLocationForColumn(int column)
   {
      for (int r = theGrid.getNumRows() - 1; r >= 0; r--)
      {
         Location nextLoc = new Location(r, column);
         if (theGrid.get(nextLoc) == null)
         {
            return nextLoc;
         }
      }
      return null;
   }

   // Precondition: 0 <= column < theGrid.getNumCols()
   // @return true if dropping a piece of the given color into the
   // specified column matches color with three neighbors;
   // otherwise, false
   public boolean dropMatchesNeighbors(int column, Color pieceColor)
   {
      Location loc = dropLocationForColumn(column);
      if (loc == null)
      {
         return false;
      }

      ArrayList<Piece> neighbors = theGrid.getNeighbors(loc);
      int colorCount = 0;
      for (Piece nextNbr : neighbors)
      {
         if (nextNbr.getColor().equals(pieceColor))
         {
            colorCount++;
         }
      }

      return (colorCount >= 4);
   }

   // There may be fields, constructors, and methods that are not shown.

   public DropGame(Grid<Piece> gr)
   {
      theGrid = gr;
   }
}
