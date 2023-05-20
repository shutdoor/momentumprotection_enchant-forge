package com.shutdoor.momentumprotection;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.shutdoor.momentumprotection.MomentumProtection.MODID;

public class EnchantmentReg {

    public static final DeferredRegister<Enchantment> ENCHANTMENT = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MODID);

    public static final RegistryObject<Enchantment> MOMENTUM_PROTECTION = ENCHANTMENT.register("momentumprotection", () -> new EnchantMomentumProtection());

}