package Search4;
import java.util.*;

public class RamblersSearch extends Search
{
  private TerrainMap map;
  private Coords goal;

  public TerrainMap getMap()
  {
      return map;
  }

  public int getGoalxPoint()
  {
      return goal.getx();
  }

  public int getGoalyPoint()
  {
      return goal.gety();
  }

  public RamblersSearch(TerrainMap m, Coords g)
  {
      map = m;
      goal = g;
  }
}
