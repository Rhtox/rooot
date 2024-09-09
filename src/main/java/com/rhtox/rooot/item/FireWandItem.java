package com.rhtox.rooot.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;

public class FireWandItem extends BowItem {
    public FireWandItem(Settings settings) {
        super(settings);
    }

    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient) {
            // Calculate charge time
            int charge = this.getMaxUseTime(stack) - remainingUseTicks;
            float power = BowItem.getPullProgress(charge);

            // Spawn fireball
            if (power >= 0.1F) {
                // Create direction vector
                Vec3d direction = user.getRotationVec(1.0F);

                // Create and spawn the fireball entity
                FireballEntity fireball = new FireballEntity(world, user, direction, (int) (power * 3.0F));
                fireball.setPosition(user.getX(), user.getEyeY() - 0.1, user.getZ());
                fireball.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, power * 3.0F, 1.0F);
                world.spawnEntity(fireball);
            }
        }
    }
}