package bot;
import ia.battle.camp.FieldCell;
import ia.battle.camp.Warrior;
import ia.battle.camp.actions.Action;
import ia.battle.camp.actions.Skip;
import ia.exceptions.RuleException;
import bot.profiles.RusherProfile;
import bot.profiles.Thinker;


public class Krieger extends Warrior{
	
	private int maxHealth;
	private KriegerManager manager;

	public Krieger(String name, int health, int defense, int strength,
			int speed, int range) throws RuleException {
		super(name, health, defense, strength, speed, range);
		
		manager = new KriegerManager();
		this.setMaxHealth(health);
	}

	@Override
	public Action playTurn(long tick, int actionNumber) {
		
		Action action;
		Thinker rusherProfile, speederProfile, kiterProfile, suicideProfile;
		
		if(this.getInitialHealth() == this.getHealth())
		{
			rusherProfile = new RusherProfile();
			action = rusherProfile.think(manager, this);
		}
		else
		{
			action = new Skip();
		}
			
		return action;
	}

	@Override
	public void wasAttacked(int damage, FieldCell source) {
		
	}

	@Override
	public void enemyKilled() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void worldChanged(FieldCell oldCell, FieldCell newCell) {
		// TODO Auto-generated method stub
		
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
}
