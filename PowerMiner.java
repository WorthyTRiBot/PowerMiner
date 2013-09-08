package scripts.powerminer;

import java.util.ArrayList;
import java.util.Collections;

import org.tribot.api.General;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;

import scripts.powerminer.api.Node;
import scripts.powerminer.nodes.DropOre;
import scripts.powerminer.nodes.MineOre;

@ScriptManifest (authors = {"Worthy"}, category = "Framework Example", name = "Basic Powerminer")
public class PowerMiner extends Script {
	public static ArrayList<Node> nodes = new ArrayList<>();
	
	@Override
	public void run() {
		Collections.addAll(nodes, new MineOre(), new DropOre());
		loop(20, 40);
	}

	private void loop(int min, int max) {
		while (true) {
			for (final Node node : nodes) {
				if (node.validate()) {
					node.execute();
					sleep(General.random(min, max));	//time in between executing nodes
				}
			}
		}
	}
}