package bot.profiles;

import ia.battle.camp.BattleField;
import ia.battle.camp.actions.Action;
import bot.Krieger;
import bot.KriegerManager;

public interface Thinker {

	public Action think(KriegerManager manager, Krieger krieger);
	
}
