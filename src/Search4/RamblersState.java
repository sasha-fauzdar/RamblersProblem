package Search4;
import java.util.ArrayList;
public class RamblersState extends SearchState{
  private  Coords statePoint;

  //constructor
  public RamblersState( Coords sp,  int lco, int ec) {
      statePoint = sp;
      localCost = lco;
      estRemCost = ec;
      
  }
  //accessors
  public int getX() {
      return statePoint.getx();
  }

  public int getY() {
      return statePoint.gety();
  }
  //goalPredicate
  boolean goalPredicate( Search searcher) {
       RamblersSearch rSearch = (RamblersSearch) searcher;
      int x = rSearch.getGoalxPoint();
      int y = rSearch.getGoalyPoint();
      if ((x == statePoint.getx()) && (y == statePoint.gety())) {
          return true;
      } else {
          return false;
      }
  }
    //Euclidean Algorithm
  public double getEuclids(int xNow, int yNow, int xGoal, int yGoal) {
	return Math.sqrt((yGoal-yNow)*(yGoal-yNow)+(xGoal-xNow)*(xGoal-xNow));
	  }
  
    //getSuccessors
  public ArrayList<SearchState> getSuccessors( Search searcher) {
       RamblersSearch rSearch = (RamblersSearch) searcher;
       TerrainMap map = rSearch.getMap();
       int[][] terrain= map.getTmap();
       ArrayList<SearchState> successors = new ArrayList<SearchState>();
      int lco = 0;
      int x = statePoint.getx();
       int y = statePoint.gety();
      
      if(y>=0) {
          if(x+1<map.getWidth())
              {if(terrain[y][x] >= terrain[y][x+1])
                  lco = 1;
              else 
                  lco = 1 + Math.abs(terrain[y][x+1] - terrain[y][x]);
              int ec=(int) getEuclids(x+1,y,rSearch.getGoalxPoint(), rSearch.getGoalyPoint());
              successors.add(new RamblersState (new Coords(y, x+1), lco, ec));}
          if(x-1>=0)
              {if(terrain[y][x] >= terrain[y+1][x])
                  lco = 1;
              else 
                  lco = 1 + Math.abs(terrain[y+1][x]-terrain[y][x]);
              int ec=(int) getEuclids(x+1,y,rSearch.getGoalxPoint(), rSearch.getGoalyPoint());
              successors.add(new RamblersState (new Coords(y+1, x), lco, ec));}
      }
      if(x>=0) {
          if(y-1>=0)
           if(y>0 && y<=map.getDepth()-1) {
              if(terrain[y][x] >= terrain[y-1][x])
                  lco= 1;
              else  
                  lco= 1 + Math.abs(terrain[y-1][x]-terrain[y][x]);
              int ec=(int) getEuclids(x+1,y,rSearch.getGoalxPoint(), rSearch.getGoalyPoint());
              successors.add(new RamblersState (new Coords(y-1, x), lco, ec));}
          if(y+1<map.getDepth())
              if(y>=0 && y<map.getDepth()-1) {
                  if(terrain[y][x] >= terrain[y+1][x])
                      lco = 1;
                  else 
                      lco = 1 + Math.abs(terrain[y+1][x]-terrain[y][x]);
                  int ec=(int) getEuclids(x+1,y,rSearch.getGoalxPoint(), rSearch.getGoalyPoint());
                  successors.add(new RamblersState (new Coords(y+1, x), lco, ec));}
      }

      
      return successors;
  }
  //sameState
  public boolean sameState( SearchState secondState) {
       RamblersState secRamblersState = (RamblersState) secondState;
      if (secRamblersState.statePoint.getx() == (statePoint.getx())) {
          if (secRamblersState.statePoint.gety() == (statePoint.gety())){
          return true;}
      else {
          return false;
          }
      } else{
          return false;
      }
  }
  //toString
  public String toString() {
      return ("Coord state:" + statePoint.getx() +", "+ statePoint.gety());
  }
  
}

