package com.shutdoor.momentumprotection;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;
import org.slf4j.Logger;
import static com.shutdoor.momentumprotection.MomentumProtection.MODID;


@Mod(MODID)
public class MomentumProtection
{
    public static final String MODID = "momentumprotection";

    @ObjectHolder(MODID +":"+ MODID)
    public static final Enchantment momentumprotection = null;

//    Enchantments

    public MomentumProtection()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Enchantment.class, this::registerEnchantments);
    }

    @SubscribeEvent
    public void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().register(new EnchantMomentumProtection().setRegistryName(MODID));
    }
}
