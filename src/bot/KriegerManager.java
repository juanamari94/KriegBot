package bot;
import ia.battle.camp.BattleField;
import ia.battle.camp.ConfigurationManager;
import ia.battle.camp.FieldCell;
import ia.battle.camp.Warrior;
import ia.battle.camp.WarriorData;
import ia.battle.camp.WarriorManager;
import ia.exceptions.OutOfMapException;
import ia.exceptions.RuleException;

import java.util.ArrayList;


public class KriegerManager extends WarriorManager{

	private BattleField battlefield;
	
	public KriegerManager()
	{
		this.battlefield = BattleField.getInstance();
	}
	
	@Override
	public String getName() {
		return "Krieger";
	}

	@Override
	public Warrior getNextWarrior() throws RuleException {
		
		return new Krieger("Krieger", 29, 1, 25, 15, 30);
	}
	

	public WarriorData reportEnemyData()
	{
		return battlefield.getEnemyData();
	}
	
	public int reportEnemyX()
	{
		return battlefield.getEnemyData().getFieldCell().getX();
	}
	
	public int reportEnemyY()
	{
		return battlefield.getEnemyData().getFieldCell().getY();
	}
	
	public ArrayList<FieldCell> reportSpecialItems()
	{
		return battlefield.getSpecialItems();
	}
	
	public boolean isFieldCellInRange(Krieger krieger, FieldCell target)
	{
		int centerX = krieger.getPosition().getX();
		int centerY = krieger.getPosition().getY();

		int range = krieger.getRange();

		int x = target.getX();
		int y = target.getY();

		if ((Math.pow(centerX - x, 2)) + (Math.pow(centerY - y, 2)) <= Math
				.pow(range, 2)) {
			return true;
		}

		return false;
	}
	
	public ArrayList<FieldCell> getMap() throws OutOfMapException
	{
		ConfigurationManager configMgr = ConfigurationManager.getInstance();
		ArrayList<FieldCell> map = new ArrayList<FieldCell>();
		
		for(int i = 0; i < configMgr.getMapWidth(); i++)
		{
			for(int j = 0; j < configMgr.getMapHeight(); j++)
			{
				map.add(battlefield.getFieldCell(i, j));
			}
		}
		
		return map;
	}
	
	public BattleField getBattlefield() {
		return battlefield;
	}

	public void setBattlefield(BattleField battlefield) {
		this.battlefield = battlefield;
	}
	
	

}
