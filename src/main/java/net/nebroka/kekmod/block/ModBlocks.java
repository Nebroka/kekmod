package net.nebroka.kekmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.nebroka.kekmod.KekMod;
import net.nebroka.kekmod.block.custom.EggplantCropBlock;
import net.nebroka.kekmod.block.custom.ShitLampBlock;
import net.nebroka.kekmod.block.custom.SpeedBlock;
import net.nebroka.kekmod.item.ModItemGroup;

public class ModBlocks {

    public static final Block SHITORE_BLOCK = registerBlock("shitore_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.SHITORE);

    public static final Block SHITORE_ORE = registerBlock("shitore_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.SHITORE);

    public static final Block DEEPSLATE_SHITORE_ORE = registerBlock("deepslate_shitore_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.SHITORE);

    public static final Block SPEED_BLOCK = registerBlock("speed_block",
            new SpeedBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.SHITORE);

    public static final Block SHIT_LAMP_BLOCK = registerBlock("shit_lamp_block",
            new ShitLampBlock(FabricBlockSettings.of(Material.GLASS).strength(3f)
                    .luminance(state -> state.get(ShitLampBlock.LIT) ? 15 : 0)), ModItemGroup.SHITORE);

    public static final Block EGGPLANT_CROP = regtisterBlockWithoutItem("eggplant_crop",
            new EggplantCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));


    private static Block regtisterBlockWithoutItem(String name, Block block){
        return Registry.register(Registry.BLOCK, new Identifier(KekMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(KekMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(KekMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks(){
        KekMod.LOGGER.debug("Registering ModBlocks for " + KekMod.MOD_ID);
    }
}
