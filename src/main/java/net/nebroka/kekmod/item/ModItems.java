package net.nebroka.kekmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nebroka.kekmod.KekMod;
import net.nebroka.kekmod.block.ModBlocks;
import net.nebroka.kekmod.item.custom.KysLolItem;


public class ModItems {

    public static final Item RAW_SHITORE = registerItem("raw_shitore",
            new Item(new FabricItemSettings().group(ModItemGroup.SHITORE)));

    public static final Item SHITORE = registerItem("shitore",
            new Item(new FabricItemSettings().group(ModItemGroup.SHITORE)));

    public static final Item KYS_LOL = registerItem("kys_lol",
            new KysLolItem(new FabricItemSettings().group(ModItemGroup.SHITORE).maxCount(1)));

    public static final Item EGGPLANT_SEEDS = registerItem("eggplant_seeds",
            new AliasedBlockItem(ModBlocks.EGGPLANT_CROP,
                    new FabricItemSettings().group(ModItemGroup.SHITORE)));

    public static final Item EGGPLANT = registerItem("eggplant",
            new Item(new FabricItemSettings().group(ModItemGroup.SHITORE)
                    .food(new FoodComponent.Builder().hunger(4).saturationModifier(4).statusEffect(
                            new StatusEffectInstance(StatusEffects.LEVITATION, 2, 1), 0.5f).build()
                    )));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(KekMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        KekMod.LOGGER.debug("Registering Mod Items for " + KekMod.MOD_ID);
    }
}
