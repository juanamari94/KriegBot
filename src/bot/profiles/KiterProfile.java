package bot.profiles;

import ia.battle.camp.actions.Action;
import ia.battle.camp.actions.Attack;
import ia.battle.camp.actions.Skip;
import bot.Krieger;
import bot.KriegerManager;
import bot.actions.KriegerMove;

public class KiterProfile implements Thinker{

	public KiterProfile()
	{
		
	}
	
	@Override
	public Action think(KriegerManager manager, Krieger krieger) {
		
		return new Skip();
	}

}
