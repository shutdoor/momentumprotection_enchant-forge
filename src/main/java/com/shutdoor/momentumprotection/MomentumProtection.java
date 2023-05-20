package com.shutdoor.momentumprotection;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.shutdoor.momentumprotection.MomentumProtection.MODID;


@Mod(MODID)
public class MomentumProtection
{
    public static final String MODID = "momentumprotection";

    public MomentumProtection()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EnchantmentReg.ENCHANTMENT.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

}
