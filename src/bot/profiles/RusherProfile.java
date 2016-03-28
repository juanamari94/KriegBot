package bot.profiles;

import ia.battle.camp.actions.Action;
import ia.battle.camp.actions.Attack;
import bot.Krieger;
import bot.KriegerManager;
import bot.actions.KriegerMove;
import bot.exceptions.UnreachableNodeException;

public class RusherProfile implements Thinker{

	public RusherProfile()
	{
		
	}
	
	@Override
	public Action think(KriegerManager manager, Krieger krieger) {
		// TODO Auto-generated method stub
		
		Action action;
		
		if(!manager.reportEnemyData().getInRange())
		{
			KriegerMove move = new KriegerMove(krieger.getPosition().getX(), 
											   krieger.getPosition().getY(), 
											   manager.reportEnemyX(), 
											   manager.reportEnemyY());
			
			try{
				move.move();
				action = move;
			}catch(UnreachableNodeException e)
			{
				DestroyerProfile destroyer = new DestroyerProfile(move);
				action = destroyer.think(manager, krieger);
			}
			
			
		}
		else
		{
			action = new Attack(manager.reportEnemyData().getFieldCell());
		}

		return action;
	}

}
