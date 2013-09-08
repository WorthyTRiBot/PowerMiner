package scripts.powerminer.nodes;

import org.tribot.api2007.Inventory;

import scripts.powerminer.api.Node;

public class DropOre extends Node {
	private final int[] PICKAXE_IDS = {1265};	//TODO add other pickaxes
	
	@Override
	public void execute() {
		Inventory.dropAllExcept(PICKAXE_IDS);
	}

	@Override
	public boolean validate() {
		return Inventory.isFull();
	}
}