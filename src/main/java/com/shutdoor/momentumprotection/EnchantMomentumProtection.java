package com.shutdoor.momentumprotection;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.shutdoor.momentumprotection.MomentumProtection.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class EnchantMomentumProtection extends Enchantment {
    public EnchantMomentumProtection() {
        super(Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, new EquipmentSlot[]{
                EquipmentSlot.CHEST
        });
    }

    @Override
    public int getMinCost(int level) {
        return 20;
    }

    @Override
    public int getMaxCost(int level) {
        return (getMinCost(level) * level);
    }

    @Override
    public int getMaxLevel() {return 4;}


    @Override
    public boolean canEnchant(ItemStack p_44689_){
        return (p_44689_.getItem() instanceof ElytraItem);
    }

    @SubscribeEvent
    public static void onPlayerDamage(LivingDamageEvent damageEvent){
        if(damageEvent.getEntity() instanceof Player) {
            Player player = (Player) damageEvent.getEntity();
            ItemStack chestPlate = player.getItemBySlot(EquipmentSlot.CHEST);
            if(ElytraItem.isFlyEnabled(chestPlate)) {
                int enchantLvl = EnchantmentHelper.getTagEnchantmentLevel(EnchantmentReg.MOMENTUM_PROTECTION.get(), chestPlate);
                if(enchantLvl > 0) {
                    if (damageEvent.getSource().equals(DamageTypes.FLY_INTO_WALL)) {
//                        System.out.println(damageEvent.getSource());

//                        System.out.println(damageEvent.getAmount());
                        damageEvent.setAmount((damageEvent.getAmount() * (0.95F / enchantLvl)));
//                        System.out.println(damageEvent.getAmount());
                    }
                }
            }

        }
    }
}
