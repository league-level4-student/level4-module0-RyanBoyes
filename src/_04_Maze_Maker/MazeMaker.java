package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		
		int ranW = randGen.nextInt(width);
		int ranH = randGen.nextInt(height);
		
		
		Cell ranCell = maze.getCell(ranW, ranH);
	
		
		//5. call selectNextPath method with the randomly selected cell
		selectNextPath(ranCell);
		
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		//A. mark cell as visited
		currentCell.setBeenVisited(true);

		//B. Get an ArrayList of unvisited neighbors using the current cell and the method below
		ArrayList<Cell> neighbors = getUnvisitedNeighbors(currentCell);
		//C. if has unvisited neighbors,
		if(neighbors.size()>0) {
			//C1. select one at random.
			Random randomNeighborGeneration = new Random();
			int ranNeighbor = randomNeighborGeneration.nextInt(neighbors.size());
			Cell randomNeighbor = neighbors.get(ranNeighbor);
			
			//C2. push it to the stack
			uncheckedCells.push(randomNeighbor);
		
			//C3. remove the wall between the two cells
			removeWalls(currentCell, randomNeighbor);

			//C4. make the new cell the current cell and mark it as visited
			currentCell = randomNeighbor;
			currentCell.setBeenVisited(true);
		
			//C5. call the selectNextPath method with the current cell
			selectNextPath(currentCell);
			
			
}
		//D. if all neighbors are visited
		else if(neighbors.size()==0) {
			//D1. if the stack is not empty
			if(uncheckedCells.isEmpty()==false) {
				// D1a. pop a cell from the stack
				Cell poppedCell = uncheckedCells.pop();
				// D1b. make that the current cell
				currentCell = poppedCell;
				// D1c. call the selectNextPath method with the current cell
				selectNextPath(currentCell);
				
			}
		}
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		int x = c1.getX();
		int y = c1.getY();
		
		if(c2.getX()==c1.getX()&&c2.getY()==c1.getY()+1) {
			c1.setSouthWall(false);
			c2.setNorthWall(false);
		}
		else if(c2.getX()==c1.getX()-1&&c2.getY()==c1.getY()) {
			c1.setWestWall(false);
			c2.setEastWall(false);
		}
		else if(c2.getX()==c1.getX()+1&&c2.getY()==c1.getY()) {
			c1.setEastWall(false);
			c2.setWestWall(false);
		}
		else if(c2.getX()==c1.getX()&&c2.getY()==c1.getY()-1) {
			c1.setNorthWall(false);
			c2.setSouthWall(false);
		}
		
		
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>();
		Cell northCell;
		Cell westCell;
		Cell eastCell;
		Cell southCell;
		
		
		
		
	
		
		
		
				
			if(c.getY()<height-1) {	
			northCell = maze.cell[c.getX()][ c.getY()+1];
		if(northCell.hasBeenVisited()==false) {
			unvisitedNeighbors.add(northCell);
		}
			}
			if(c.getX()>0) {
			westCell = maze.cell[c.getX()-1][ c.getY()];
		 if(westCell.hasBeenVisited()==false) {
			unvisitedNeighbors.add(westCell);
		}
			}
			if(c.getX()<width-1) {
			eastCell = maze.cell[c.getX()+1][ c.getY()];
		 if(eastCell.hasBeenVisited()==false) {
			unvisitedNeighbors.add(eastCell);
		}
			}
			if(c.getY()>0) {
			southCell = maze.cell[c.getX()][ c.getY()-1];
		 if(southCell.hasBeenVisited()==false) {
			unvisitedNeighbors.add(southCell);
		}
			}
		
		
		
		
		
			
			
			return unvisitedNeighbors;
	}
}
