package scripts.powerminer.nodes;

import org.tribot.api.General;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSObject;

import scripts.powerminer.api.Node;

public class MineOre extends Node {
	private final int[] ROCK_IDS = {20843, 20844, 20845};	//tin ore 
	
	@Override
	public void execute() {
		RSObject rock = findNearest(15, ROCK_IDS);
		if (rock != null && Player.getAnimation() == -1) {
			rock.click("Mine");
			
			int timeout = 0;
			while (Player.getAnimation() == -1) {	
				timeout++;
				General.sleep(10);
				if (timeout > 250)	//waits up to 2.5 seconds until the players animation changes
					break;			//prevents bot from spam clicking ore
			}
		}
	}

	@Override
	public boolean validate() {
		return !Inventory.isFull();
	}
	
	private RSObject findNearest(int distance, int ...ids) {
		RSObject[] objs = Objects.findNearest(distance, ids);
		if (objs.length > 0)
			return objs[0];
		return null;
	}
}