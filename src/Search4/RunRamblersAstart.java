package Search4;

import java.util.Random;

public class RunRamblersAstart {
	public static void main(String[] args) {
	TerrainMap tmap = new TerrainMap("tmc.pgm");
	Random random = new Random();
	
	
	int xNow = random.nextInt(tmap.getWidth());
	int yNow = random.nextInt(tmap.getDepth());
	int xGoal = random.nextInt(tmap.getWidth());
	int yGoal = random.nextInt(tmap.getDepth());
	
	Coords start = new Coords(yNow, xNow);
	Coords goal = new Coords(yGoal, xGoal);
	
	
	RamblersSearch searcher = new RamblersSearch(tmap,goal); 
    SearchState initState = (SearchState) new RamblersState(start,0, 0);
    String res_astar = searcher.runSearch(initState, "AStar");
    System.out.println(res_astar);}
}

