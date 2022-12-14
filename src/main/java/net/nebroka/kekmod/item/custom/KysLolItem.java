package net.nebroka.kekmod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KysLolItem extends Item {
    private int randomNr;
    public KysLolItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient()){
            //calc random number 1-100
            getRandInt();
            //if random number is 69, die
            outputRandInt(user);
            //cooldown 15 s
            user.getItemCooldownManager().set(this, 300);
        }

        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.literal(
                    "Generates a random value between 1-100, and kills you if it rolls 69 -> xd").formatted(Formatting.DARK_GRAY).formatted(Formatting.ITALIC));
        } else{
            tooltip.add(Text.literal("Press [shift] for more information!").formatted(Formatting.DARK_GRAY).formatted(Formatting.ITALIC));
        }


        super.appendTooltip(stack, world, tooltip, context);
    }

    private void getRandInt(){
        randomNr = Random.createLocal().nextInt(100);
    }

    private int randomLol(){
        return Random.createLocal().nextInt(5);
    }

    private void outputRandInt(PlayerEntity player){
        if(randomNr != 69){
            player.teleport(player.getX()+randomLol(), player.getY()+randomLol(), player.getZ()+randomLol(), false);
            player.sendMessage(Text.literal("You live to see another day. Your number was: " + randomNr));
        }
        else {
            player.kill();
            player.sendMessage(Text.literal("Haha funny number 69 you die lol!"));
        }
    }


}
