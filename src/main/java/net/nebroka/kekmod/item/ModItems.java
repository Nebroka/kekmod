package net.nebroka.kekmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nebroka.kekmod.KekMod;


public class ModItems {

    public static final Item RAW_SHITORE = registerItem("raw_shitore",
            new Item(new FabricItemSettings().group(ModItemGroup.SHITORE)));

    public static final Item SHITORE = registerItem("shitore",
            new Item(new FabricItemSettings().group(ModItemGroup.SHITORE)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(KekMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        KekMod.LOGGER.debug("Registering Mod Items for " + KekMod.MOD_ID);
    }
}
