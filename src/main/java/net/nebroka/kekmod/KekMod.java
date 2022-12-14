package net.nebroka.kekmod;

import net.fabricmc.api.ModInitializer;
import net.nebroka.kekmod.block.ModBlocks;
import net.nebroka.kekmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KekMod implements ModInitializer {
	public static final String MOD_ID = "kekmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}
