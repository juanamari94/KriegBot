package bot.profiles;

import ia.battle.camp.actions.Action;
import ia.battle.camp.actions.Skip;
import bot.Krieger;
import bot.KriegerManager;

public class SpeederProfile implements Thinker{

	public SpeederProfile()
	{
		
	}
	
	@Override
	public Action think(KriegerManager manager, Krieger krieger) {
		// TODO Auto-generated method stub
		return new Skip();
	}

}
