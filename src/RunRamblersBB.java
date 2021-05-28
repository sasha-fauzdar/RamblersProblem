import java.util.Random;


public class RunRamblersBB {
public static void main(String[] args) {
    
    TerrainMap tmap = new TerrainMap("tmc.pgm");
	Random random = new Random();
	
	
	int startX = random.nextInt(tmap.getWidth());
	int startY = random.nextInt(tmap.getDepth());
	int goalX = random.nextInt(tmap.getWidth());
	int goalY = random.nextInt(tmap.getDepth());
	
	Coords start = new Coords(startY, startX);
	Coords goal = new Coords(goalY, goalX);
	
	
	RamblersSearch searcher = new RamblersSearch(tmap,goal); 
    SearchState initState = (SearchState) new RamblersState(start,0);
    String res_bb = searcher.runSearch(initState, "branchAndBound");
    System.out.println(res_bb);}}
