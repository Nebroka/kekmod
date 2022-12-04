package net.nebroka.kekmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.nebroka.kekmod.KekMod;

public class ModItemGroup {
    public static final ItemGroup SHITORE = FabricItemGroupBuilder.build(
            new Identifier(KekMod.MOD_ID, "shitore"), () -> new ItemStack(ModItems.SHITORE));

}
