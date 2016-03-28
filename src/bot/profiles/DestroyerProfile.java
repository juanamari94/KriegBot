package bot.profiles;

import ia.battle.camp.BattleField;
import ia.battle.camp.FieldCell;
import ia.battle.camp.FieldCellType;
import ia.battle.camp.actions.Action;
import ia.battle.camp.actions.Attack;

import java.util.List;

import bot.Krieger;
import bot.KriegerManager;
import bot.actions.KriegerMove;

public class DestroyerProfile implements Thinker{
	
	public DestroyerProfile(KriegerMove move)
	{
		
	}

	@Override
	public Action think(KriegerManager manager, Krieger krieger) {
		
		FieldCell targetCell;
		List<FieldCell> adjacentCells = BattleField.getInstance().getAdjacentCells(krieger.getPosition());
		
		targetCell = adjacentCells.get(0);
		
		targetCell = this.getClosestCell(adjacentCells, targetCell, manager);
		
		/*while(targetCell.getFieldCellType() == FieldCellType.NORMAL && manager.isFieldCellInRange(krieger, targetCell))
		{
			System.out.println("¿me trabé?");
			targetCell = this.getClosestCell(adjacentCells, targetCell, manager);
			
		}*/
		
		if(targetCell.getFieldCellType() == FieldCellType.BLOCKED || BattleField.getInstance().getSpecialItems().contains(targetCell))
			return new Attack(targetCell);
		else
			return new KriegerMove(krieger.getPosition().getX(), krieger.getPosition().getY(), targetCell.getX(), targetCell.getY());
	}

	private FieldCell getClosestCell(List<FieldCell> adjacentCells, FieldCell targetCell, KriegerManager manager)
	{
		for(FieldCell c : adjacentCells)
		{
			if(c.getFieldCellType() == FieldCellType.BLOCKED || BattleField.getInstance().getSpecialItems().contains(c))
				if(this.getDistance(c.getX(), c.getY(), manager.reportEnemyX(), manager.reportEnemyY()) 
						< 
						this.getDistance(targetCell.getX(), targetCell.getY(), manager.reportEnemyX(), manager.reportEnemyY()))
					targetCell = c;
					
		}
		
		return targetCell;
	}
	
	private int getDistance(int x0, int y0, int x1, int y1)
	{
		return Math.abs(x1-x0) + Math.abs(y1-y0);
	}
	
	
}
