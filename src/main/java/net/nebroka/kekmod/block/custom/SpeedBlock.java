package net.nebroka.kekmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SpeedBlock extends Block {
    public SpeedBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.literal(
                    "If stood on; grants Speed 5, if broken; gives slowness 7"
            ).formatted(Formatting.DARK_GRAY).formatted(Formatting.ITALIC));
        }
        else{
            tooltip.add(Text.literal(
                    "Press [shift] for more information!"
            ).formatted(Formatting.DARK_GRAY).formatted(Formatting.ITALIC));
        }
        super.appendTooltip(stack, world, tooltip, options);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if(!world.isClient()){
            player.addStatusEffect(
                    new StatusEffectInstance(StatusEffects.SLOWNESS, 50, 6)
            );
        }
        super.onBreak(world, pos, state, player);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(!world.isClient()) {
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.addStatusEffect(
                        new StatusEffectInstance(StatusEffects.SPEED, 2, 4));
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}
