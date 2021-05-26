import java.util.ArrayList;
public class RamblersState extends SearchState{
    private  Coords statePoint;

    public RamblersState( Coords sp,  int lco) {
        statePoint = sp;
        localCost = lco;
    }

    public int getX() {
        return statePoint.getx();
    }

    public int getY() {
        return statePoint.gety();
    }

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
                successors.add(new RamblersState (new Coords(y, x+1), lco));}
            if(x-1>=0)
                {if(terrain[y][x] >= terrain[y+1][x])
                    lco = 1;
                else 
                    lco = 1 + Math.abs(terrain[y+1][x]-terrain[y][x]);
                successors.add(new RamblersState (new Coords(y+1, x), lco));}
        }
        if(x>=0) {
            if(y-1>=0)
             if(y>0 && y<=map.getDepth()-1) {
                if(terrain[y][x] >= terrain[y-1][x])
                    lco= 1;
                else  
                    lco= 1 + Math.abs(terrain[y-1][x]-terrain[y][x]);
                successors.add(new RamblersState (new Coords(y-1, x), lco));}
            if(y+1<map.getDepth())
                if(y>=0 && y<map.getDepth()-1) {
                    if(terrain[y][x] >= terrain[y+1][x])
                        lco = 1;
                    else 
                        lco = 1 + Math.abs(terrain[y+1][x]-terrain[y][x]);
                    successors.add(new RamblersState (new Coords(y+1, x), lco));}
        }

        
        return successors;
    }

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

    public String toString() {
        return ("Coord state:" + statePoint.getx() +", "+ statePoint.gety());
    }
    
}
