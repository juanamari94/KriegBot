package bot.actions;
import ia.battle.camp.BattleField;
import ia.battle.camp.ConfigurationManager;
import ia.battle.camp.FieldCell;
import ia.battle.camp.FieldCellType;
import ia.exceptions.OutOfMapException;

import java.util.ArrayList;

import bot.exceptions.UnreachableNodeException;
import bot.movement.AStar;
import bot.movement.Node;


public class KriegerMove extends ia.battle.camp.actions.Move{


	private int x1, x2, y1, y2;
	
	public KriegerMove(int x1, int y1, int x2, int y2)
	{
		this.setX1(x1);
		this.setY1(y1);
		this.setX2(x2);
		this.setY2(y2);
	}
	
	@Override
	public ArrayList<FieldCell> move() {
		//System.out.println("###");
		return findPath(this.getX1(),this.getY1(), this.getX2(), this.getY2());
	}
	
	private ArrayList<FieldCell> findPath(int x1, int y1, int x2, int y2) throws UnreachableNodeException
	{
		AStar astar = new AStar(this.translateToMap());
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		try{
			nodes = astar.findPath(x1, y1, x2, y2); // Algoritmo A*
		}catch(IndexOutOfBoundsException e)
		{
			throw new UnreachableNodeException();
		}
		
		ArrayList<FieldCell> nodecells = new ArrayList<FieldCell>();
		BattleField battlefield = BattleField.getInstance();
		
		for(Node n : nodes)
		{
			try {
				nodecells.add(battlefield.getFieldCell(n.getX(), n.getY()));
			} catch (OutOfMapException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return nodecells;
	}
	
	private int[][] translateToMap()
	{
		ConfigurationManager configurationManager = ConfigurationManager.getInstance();
		BattleField battlefield = BattleField.getInstance();
		int width = configurationManager.getMapWidth();
		int height = configurationManager.getMapHeight();
		int[][] map = new int[width][height];
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				try {
					if(battlefield.getFieldCell(i,  j).getFieldCellType() == FieldCellType.NORMAL)
						map[i][j] = 0;
					else
						map[i][j] = 1;
				} catch (OutOfMapException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return map;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	
	
}
